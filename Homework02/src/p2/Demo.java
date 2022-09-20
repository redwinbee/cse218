package p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String paragraph = readSample();
        System.out.println("--- ORIGINAL ---");
        System.out.println(paragraph);

        Reverser reverser = new Reverser(paragraph);
        System.out.println("--- REVERSED SENTENCES ---");
        System.out.println(reverser.reverseSentences());

        System.out.println("--- REVERSED CHARACTERS --- ");
        System.out.println(reverser.reverseCharacters());
    }

    private static String readSample() {
        File file = new File("sample.txt");
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }

            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("[err]: failed to read file.");
            return null;
        }
    }
}
