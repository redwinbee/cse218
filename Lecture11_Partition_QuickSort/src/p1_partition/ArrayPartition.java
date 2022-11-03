package p1_partition;

@SuppressWarnings("all") // duplicates and empty bodies
public class ArrayPartition {
    private final long[] array;
    private int elements;

    public ArrayPartition(int maxSize) {
        this.array = new long[maxSize];

    }

    public void insert(long value) {
        array[elements++] = value;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && array[++leftPtr] < pivot) {
                // haven't crossed over to the right partition
                // no-op
            }

            while (rightPtr > left && array[--rightPtr] >= pivot) {
                // haven't crossed over to the left partition
                // no-op
            }

            if (leftPtr >= rightPtr) {
                break;
            } else {
                // we need to swap the values to put the on the "right side" of the partition
                swap(leftPtr, rightPtr);
            }
        }

        return leftPtr;
    }

    private void swap(int leftPtr, int rightPtr) {
        long temp = array[rightPtr];
        array[rightPtr] = array[leftPtr];
        array[leftPtr] = temp;
    }
}
