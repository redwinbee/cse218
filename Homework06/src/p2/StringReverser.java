package p2;

public class StringReverser {
    public static void main(String[] args) {
        String word = "Machine";
        String reversed = reverseString(word.toCharArray(), new StringBuilder(), word.length() - 1);
        System.out.println("[original]: " + word);
        System.out.println("[reversed]: " + reversed);
    }

    private static String reverseString(char[] chars, StringBuilder builder, int idx) {
        if (idx == -1) {
            return builder.toString();
        } else {
            builder.append(chars[idx]);
            return reverseString(chars, builder, --idx);
        }
    }
}
