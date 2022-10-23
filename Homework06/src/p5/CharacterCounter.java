package p5;

public class CharacterCounter {
    private static final int MAX_ELEMENTS = 10;

    public static void main(String[] args) {
        char[] array = getRandomCharArray();
        char key = (char) (Math.random() * 26 + 'a');
        int charCount = characterCount(array, 0, 0, key);
        display(array);
        System.out.printf("[result]: the letter '%c' appears in the array %d time(s)%n", key, charCount);
    }

    private static int characterCount(char[] array, int currentCount, int idx, char key) {
        if (idx >= array.length) {
            return currentCount;
        } else {
            if (array[idx] == key) {
                currentCount++;
            }
            return characterCount(array, currentCount, ++idx, key);
        }
    }

    private static char[] getRandomCharArray() {
        char[] array = new char[MAX_ELEMENTS];
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) ((Math.random() * 26) + 'a');
        }

        return array;
    }

    private static void display(char[] values) {
        int count = 0;
        for (int element : values) {
            System.out.printf("[%d]: %c%n", count++, element);
        }
    }
}
