package p3;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 6, 9, 23, 34, 67, 89, 98};
        int idx = binarySearch(numbers,0, numbers.length - 1, 89);
        System.out.println("idx: " + idx);
    }

    /**
     * Binary search using recursion. This method assumes the values provided in the array
     * are already sorted.
     * @param array The array to search through
     * @param first Where to start in the array
     * @param last Where to end in the array
     * @param key The value to look for
     * @return -1 if the value was not found, otherwise the index value of where the key is located
     */
    private static int binarySearch(int[] array, int first, int last, int key) {
        if (first > last) {
            return -1; // not found
        }
        int middle = (first + last) / 2;
        if (array[middle] == key) {
            return middle; // found
        } else if(array[middle] < key) {
            first = middle + 1; // don't care about bottom half of array
            return binarySearch(array, first ,last, key);
        } else {
            last = middle - 1; // don't care about top half of array
            return binarySearch(array, first, last, key);
        }
    }
}
