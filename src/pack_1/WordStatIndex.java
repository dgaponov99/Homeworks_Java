package pack_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordStatIndex {
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Передайте имена входного и выходного файла аргументами при запуске программы");
            return;
        }

        LinkedHashMap<String, Word> wordsList = new LinkedHashMap<>();

        try (Scanner text = new Scanner(new File(args[0]), "UTF-8")) {
            int k = 0;
            String word;
            while (text.hasNext()) {
                word = text.next().toLowerCase();
                word = Word.validationWord(word);
                if (wordsList.containsKey(word)) {
                    Word tempWorld = wordsList.get(word);
                    tempWorld.numbers.add(k);
                    tempWorld.counter++;
                    wordsList.put(word, tempWorld);
                } else {
                    wordsList.put(word, new Word(k));
                }
                k++;
            } // end while
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Передайте имя входного файла первым аргументом при запуске программы");
            return;
        } // end input try

        try (PrintWriter writer = new PrintWriter(new File(args[1]))) {
            for (String key : wordsList.keySet()) {
                Word tempWorld = wordsList.get(key);
                StringBuilder numbers = new StringBuilder();
                for (Integer number : tempWorld.numbers) {
                    numbers.append(" ").append(number);
                } // end for
                writer.println(key + " " + tempWorld.counter + numbers);
            } // end for
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Передайте имя выходного файла вторым аргументом при запуске программы");
        } // end output try
    } // end main
} // end WordStatIndex

class Word {
    int counter = 1;
    ArrayList<Integer> numbers = new ArrayList<>();

    Word(Integer fistNumber) {
        this.numbers.add(fistNumber);
    } // end constructor

    public static String validationWord(String word) {
        char[] symbols = word.toCharArray();
        int len = word.length();
        if (Character.isDigit(symbols[0])) {
            return null;
        }
        if (!Character.isLetter(symbols[len - 1])) {
            len -= 1;
        }
        for (int i = 0; i < len; i++) {
            if (!(Character.isLetter(symbols[i]) || symbols[i] == '-' || symbols[i] == '\'')) {
                return null;
            }
        } // end for
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            wordBuilder.append(symbols[i]);
        } // end for
        return wordBuilder.toString();
    } // end validationWord

} // end Word
