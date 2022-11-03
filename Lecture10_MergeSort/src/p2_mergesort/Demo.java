package p2_mergesort;

import java.util.Arrays;

public class Demo {
    private static final int ITERATIONS = 10;
    private static final int MAX_ELEMENTS = 10_000_000;
    private static final double[] RUNTIMES = new double[ITERATIONS];
    private static int counter = 0;

    public static void main(String[] args) {
        for (int i = 0; i < ITERATIONS; i++) {
            System.out.printf("[bench::%d]: running...%n", i);
            runBenchmark();
        }

        double avgRuntime = Arrays.stream(RUNTIMES).sum() / 1_000_000.0;
        System.out.printf("[results]: average runtime of %.2f over %d iteration(s)%n", avgRuntime, ITERATIONS);
    }

    private static void runBenchmark() {
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

        RUNTIMES[counter++] = (endTime - startTime) / 1_000_000.0;
    }
}
