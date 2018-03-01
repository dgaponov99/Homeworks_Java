package pack_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordStatIndex {
    public static void main(String[] args) {

        LinkedHashMap<String, Word> wordsList = new LinkedHashMap<>();

        try (Scanner text = new Scanner(new File(args[0]), "UTF-8")) {
            int k = 0;
            String word;
            while (text.hasNext()) {
                word = text.next().toLowerCase();
                if (wordsList.containsKey(word)) {
                    Word tempWorld = wordsList.get(word);
                    tempWorld.numbers.add(k);
                    tempWorld.counter++;
                    wordsList.put(word, tempWorld);
                } else {
                    wordsList.put(word, new Word(k));
                }
                k++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Передайте имя входного файла первым аргументом при запуске программы");
            System.exit(1);
        } // end input try

        try (PrintWriter writer = new PrintWriter(new File(args[1]))) {
            for (String key : wordsList.keySet()) {
                Word tempWorld = wordsList.get(key);
                StringBuilder numbers = new StringBuilder();
                for (Integer number: tempWorld.numbers) {
                    numbers.append(" ").append(number);
                }
                writer.println(key + " " + tempWorld.counter + numbers);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Передайте имя выходного файла вторым аргументом при запуске программы");
            System.exit(1);
        }

    } // end main
} // end WordStatIndex

class Word {
    int counter = 1;
    ArrayList<Integer> numbers = new ArrayList<>();

    Word(Integer fistNumber) {
        this.numbers.add(fistNumber);
    }

} // end Word