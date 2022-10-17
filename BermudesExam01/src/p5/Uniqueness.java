package p5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.LinkedList;

public class Uniqueness {
    private static final File WORDS_TXT = new File("words.txt");

    public static void main(String[] args) {
        String[] words = extractWords();
        LinkedList<String> uniqueWords = extractUniqueWords(words);
        display(uniqueWords);
    }

    private static LinkedList<String> extractUniqueWords(String[] array) {
        LinkedList<String> list = new LinkedList<>();
        Arrays.stream(array).map(String::toLowerCase).distinct().forEach(list::add);
        return list;
    }

    private static String[] extractWords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(WORDS_TXT))) {
            return reader.readLine().split(" ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private static <E> void display(AbstractList<E> list) {
        int count = 0;
        for (E value : list) {
            System.out.printf("[%d]: %s%n", count++, value);
        }
    }
}
