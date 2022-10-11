package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Parser {
    private final File textFile;
    private String[] contents;

    public Parser(File textFile) {
        this.textFile = textFile;
        if (textFile.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(textFile));
                contents = br.readLine().split(" ");
            } catch (IOException ex) {
                System.out.println("[err]: failed to parse file!");
                ex.printStackTrace();
            }
        }
    }

    public LinkedList<String> constructChildren() {
        LinkedList<String> parent = constructParent();
        for (String distinct : parent) {

        }

        return null; // TODO
    }

    public LinkedList<String> constructParent() {
        LinkedList<String> parent = new LinkedList<>();
        Arrays.stream(contents).distinct().forEach(parent::add);
        return parent;
    }

    public File getTextFile() {
        return textFile;
    }

    public String[] getContents() {
        return contents;
    }
}
