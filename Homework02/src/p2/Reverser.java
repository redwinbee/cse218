package p2;

import p1.StackZ;

public class Reverser {
    private final String paragraph;

    public Reverser(String paragraph) {
        this.paragraph = paragraph;
    }

    public String reverseSentences() {
        String[] paragraphSentences = paragraph.split("\\.");
        StackZ stackZ = new StackZ(paragraphSentences.length);
        for (int i = 0; i < paragraphSentences.length; i++) {
            stackZ.push(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!stackZ.isEmpty()) {
            sb.append(paragraphSentences[(int) stackZ.pop()]);
            sb.append('.');
        }
        return sb.toString().trim();
    }

    public String reverseCharacters() {
        StackZ stackZ = new StackZ(paragraph.length());
        char[] chars = paragraph.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stackZ.push(chars[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!stackZ.isEmpty()) {
            sb.append((char) (stackZ.pop()));
        }

        return sb.toString();
    }
}
