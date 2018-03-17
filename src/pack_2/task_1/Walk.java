package pack_2.task_1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Walk {

    private static final int ArgNumbers = 2;
    private static HashMap<String, String> pathMap = new HashMap<>();


    public static void main(String[] args) {

        if (!validationArgs(args)) {
            System.out.println("Передайте имена входного и выходного файла аргументами при запуске");
            return;
        }

        try {
            readInput(args[0]);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Входной файл не найден");
            System.out.println("Укажите имя входного файла первым аргументом при запуске");
        }

        byte[] bytes;
        String hash;
        ArrayList<String> keyForRemove = new ArrayList<>();
        for (String path : pathMap.keySet()) {
            try {
                bytes = readByteContent(path);
                hash = Integer.toHexString(FNVHash.hash32(bytes));
                pathMap.put(path, hash);
            } catch (IOException e) {
                //e.printStackTrace();
                keyForRemove.add(path);
                System.out.println("Файла " + path + " не существует");
            }
        }

        System.out.println(pathMap.toString());

        for (String key: keyForRemove){
            pathMap.remove(key);
        }

        if (pathMap.isEmpty()) {
            System.out.println("Все файлы отсутствуют");
            return;
        }

        try {
            writeOutput(args[1]);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Невалидное имя выходного файла");
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            System.out.println("Запись в кодировке UTF-8 невозможна");
        }


    }

    private static boolean validationArgs(String[] args) {
        return args.length == ArgNumbers;
    }

    private static void readInput(String path) throws FileNotFoundException {
        Scanner scannerFile = null;
        try {
            scannerFile = new Scanner(new File(path), "UTF8");
            while (scannerFile.hasNextLine()) {
                putKeyToMap(scannerFile.nextLine());
            }
        } finally {
            if (scannerFile != null) {
                scannerFile.close();
            }
        }
    }

    private static byte[] readByteContent(String path) throws IOException {
        ByteArrayOutputStream out = null;
        InputStream input = null;
        try {
            out = new ByteArrayOutputStream();
            input = new BufferedInputStream(new FileInputStream(path));
            int data;
            while ((data = input.read()) != -1) {
                out.write(data);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (out != null) {
                out.close();
            }
        }
        return out.toByteArray();
    }

    private static void putKeyToMap(String key) {
        if (!pathMap.containsKey(key)) {
            pathMap.put(key, null);
        }
    }

    private static void writeOutput(String path) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(path), "UTF8");
            for (String key : pathMap.keySet()) {
                writer.println(pathMap.get(key) + " " + key);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
