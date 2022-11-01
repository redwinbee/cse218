package p2_mergesort;

public class MergeSortArray {
    private final long[] array;
    private int elements;

    public MergeSortArray(int maxSize) {
        this.array = new long[maxSize];
    }

    public void mergeSort() {
        long[] workspace = new long[elements];
        recursiveMergeSort(workspace, 0, elements - 1);
    }

    public void recursiveMergeSort(long[] workspace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int middle = (lowerBound + upperBound) / 2;
            recursiveMergeSort(workspace, lowerBound, middle); // sort lower half
            recursiveMergeSort(workspace, middle + 1, upperBound); // sort upper half
            merge(workspace, lowerBound, middle + 1, upperBound);
        }
    }

    public void merge(long[] workspace, int lowPtr, int highPtr, int upperBound) {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int middle = highPtr - 1;
        int n = (upperBound - lowerBound) + 1; // # of data items

        while (lowPtr <= middle && highPtr <= upperBound) {
            if (array[lowPtr] <= array[highPtr]) {
                workspace[j++] = array[lowPtr++];
            } else {
                workspace[j++] = array[highPtr++];
            }
        }

        // higher half is done
        while (lowPtr <= middle) {
            workspace[j++] = array[lowPtr++];
        }

        // lower half is done
        while (highPtr <= upperBound) {
            workspace[j++] = array[highPtr++];
        }

        // copy everything in the workspace back into the original array
        for (j = 0; j < n; j++) {
            array[lowerBound + j] = workspace[j];
        }
    }

    public void insert(long value) {
        array[elements++] = value;
    }

    public int size() {
        return elements;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
