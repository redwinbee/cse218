package p1;

import java.io.File;
import java.util.List;

public class Main {
    private static final File TEXT_FILE = new File("data/blowingInTheWind.txt");

    public static void main(String[] args) {
        Parser parser = new Parser(TEXT_FILE);
    }

    private static void display(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("[%d]: %s%n", i, list.get(i));
        }
    }
}
