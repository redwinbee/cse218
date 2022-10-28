package p3;

public class MaxElement {
    private static final int MAX_ELEMENTS = 10;
    private static final int UPPER_LIMIT = 10;

    public static void main(String[] args) {
        int[] array = getRandomIntArray();
        int maxValue = getMaxElement(array);
        display(array);
        System.out.printf("[result]: max value of array is %d%n", maxValue);
    }

    private static int getMaxElement(int[] array) {
        // just makes calling this method a bit cleaner
        return getMaxElement(array, -1, 0);
    }

    private static int getMaxElement(int[] array, int currentMax, int idx) {
        if (idx >= array.length) {
            return currentMax;
        } else {
            currentMax = Math.max(array[idx], currentMax);
            return getMaxElement(array, currentMax, ++idx);
        }
    }

    private static int[] getRandomIntArray() {
        int[] array = new int[MAX_ELEMENTS];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * UPPER_LIMIT);
        }

        return array;
    }

    private static void display(int[] values) {
        int count = 0;
        for (int element : values) {
            System.out.printf("[%d]: %s%n", count++, element);
        }
    }
}
