package p4;

public class Palindrome {
    private static final String WORD = "racecar";

    public static void main(String[] args) {
        System.out.println(isPalindrome(WORD, 0, WORD.toCharArray().length - 1));
    }

    /**
     * Determines if a string is a palindrome
     *
     * @param word The word to check
     * @return Whether it was a palindrome
     */
    private static boolean isPalindrome(String word, int first, int last) {
        if (first > last) {
            return true; // done checking all letters
        }

        char[] chars = word.toCharArray();
        if (chars[first] == chars[last]) {
            return isPalindrome(word, ++first, --last);
        } else {
            return false;
        }
    }
}
