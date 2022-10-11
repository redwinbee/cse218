package p1;

import p1.obj.Link;
import p1.obj.MainLinkedList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Parser {
    private ArrayList<String> contents;

    public Parser(File textFile) {
        if (textFile.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(textFile));
                String[] words = br.readLine().split(" ");
                contents = new ArrayList<>(words.length);
                Collections.addAll(contents, words);
            } catch (IOException ex) {
                System.out.println("[err]: failed to parse file!");
                ex.printStackTrace();
            }
        }
    }

    public MainLinkedList construct() {
        MainLinkedList mainList = new MainLinkedList();
        contents.stream().distinct().forEach(mainList::add);

        for (int i = 0; i < contents.size(); i++) {
            Link result = mainList.search(contents.get(i));
            if (result != null) { // TODO this should actually never be null right??
                try {
                    result.getChildren().add(contents.get(i + 1));
                } catch (IndexOutOfBoundsException ignored) {
                    // no more children to add
                }
            }
        }

        return mainList;
    }
}
