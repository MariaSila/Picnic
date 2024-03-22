package Picnic;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class ListWords {
    public static void main(String[] args) throws FileNotFoundException {
        getWordCount("input.txt");
        getMaxlengthWord("input.txt");
        countUnique("input.txt");
    }


    public static String[] fileOpen(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String[] words = new String[0];
        while (scanner.hasNextLine()) {
            words = scanner.nextLine().split(" ");
        }
        scanner.close();
        return words;
    }

    public static void getWordCount(String filename) throws FileNotFoundException{
        String[] words = fileOpen(filename);
        int countWords = words.length;
        System.out.println("Количество слов в файле: " + countWords);
    }
    public static void getMaxlengthWord(String filename) throws FileNotFoundException {
        String[] words = fileOpen(filename);
        String wordWithMaxLength = "";

        for (String s : words) {
            Arrays.sort(words, Comparator.comparing(String::length, Comparator.reverseOrder()));
            wordWithMaxLength = words[0].length() > wordWithMaxLength.length() ? words[0] : wordWithMaxLength;
        }
        System.out.println("Самое длиное слово: " + wordWithMaxLength);

    }

    public static void countUnique(String filename) throws FileNotFoundException {
        String[] words = fileOpen(filename);
        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : words)
        {
            String wordLower = word.toLowerCase();
            if (!wordToCount.containsKey(wordLower))
            {
                wordToCount.put(wordLower, 0);
            }
            wordToCount.put(wordLower, wordToCount.get(wordLower) + 1);
        }
        System.out.println("Список для пикника: ");
        for (String word : wordToCount.keySet())
        {
            System.out.println(word + " " + wordToCount.get(word));
        }
    }

}
