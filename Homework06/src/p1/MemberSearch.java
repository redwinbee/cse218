package p1;

public class MemberSearch {
    private static final int MAX_ELEMENTS = 10;
    private static final int UPPER_LIMIT = 10;

    public static void main(String[] args) {
        int[] array = getRandomIntArray();
        int query = (int) (Math.random() * UPPER_LIMIT);
        boolean hasQuery = isMember(array, 0, query);
        display(array);
        System.out.printf("[result]: the number %d was %s in the array%n", query, hasQuery ? "found" : "not found");
    }

    private static boolean isMember(int[] array, int idx, int key) {
        if (idx == array.length) {
            return false;
        } else {
            return array[idx] == key || isMember(array, ++idx, key);
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
