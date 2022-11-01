package p2_mergesort;

import java.util.Arrays;

public class Demo {
    private static final int MAX_ELEMENTS = 1_000_000;

    public static void main(String[] args) {
        MergeSortArray array1 = new MergeSortArray(MAX_ELEMENTS);
        int[] array2 = new int[MAX_ELEMENTS];
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            int randomVal = (int) (Math.random() * 10 + 1);
            array1.insert(randomVal);
            array2[i++] = randomVal;
        }

        //array1.display();
        long startTime = System.nanoTime();
        array1.mergeSort();
        long endTime = System.nanoTime();
        //array1.display();

        long startTime2 = System.nanoTime();
        Arrays.sort(array2);
        long endTime2 = System.nanoTime();


        System.out.println("array1 size: " + array1.size());
        System.out.println("array2 size: " + array2.length);
        System.out.printf("[runtime::array1]: %fms%n", (endTime - startTime) / 1_000_000.0);
        System.out.printf("[runtime::array2]: %fms%n", (endTime2 - startTime2) / 1_000_000.0);

    }
}
