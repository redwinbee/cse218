package p1_merge;

public class MergeApp {
    public static void main(String[] args) {
        int[] arrayA = {2, 4, 7, 9, 12, 16, 20};
        int[] arrayB = {1, 4, 8, 9, 12, 19, 22, 30};
        int[] arrayC = new int[arrayA.length + arrayB.length];

        merge(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
        display(arrayC, arrayC.length);
    }

    // the basis of MergeSort, we assume the data is already sorted and this is only merging
    private static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;

        // neither array is finished
        while (aIndex < sizeA && bIndex < sizeB) {
            if (arrayA[aIndex] < arrayB[bIndex]) {
                arrayC[cIndex++] = arrayA[aIndex++]; // A index is smaller
            } else {
                arrayC[cIndex++] = arrayB[bIndex++]; // B index is smaller
            }
        }

        // array B is finished
        while (aIndex < sizeA) {
            arrayC[cIndex++] = arrayA[aIndex++];
        }

        // array A is finished
        while (bIndex < sizeB) {
            arrayC[cIndex++] = arrayB[bIndex++];
        }
    }

    private static void display(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.printf("[%d]: %s%n", i, array[i]);
        }
        System.out.println();
    }
}
