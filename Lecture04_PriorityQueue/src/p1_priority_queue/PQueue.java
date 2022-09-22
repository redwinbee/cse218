package p1_priority_queue;

public class PQueue {
    private final long[] array;
    private final int maxSize;
    private int elements;

    public PQueue(int maxSize) {
        this.array = new long[maxSize];
        this.maxSize = maxSize;
        this.elements = 0;
    }

    public void insert(long value) {
        int j;
        if (elements == 0) { // just insert value into empty array
            array[0] = value;
        } else { // not empty, need to do comparisons
            for (j = elements - 1; j >= 0; j--) {
                if (value > array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
        elements++;
    }

    public long peek() {
        return array[elements - 1];
    }

    public long remove() {
        return array[--elements];
    }

    public boolean isFull() {
        return elements == maxSize;
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public int size() {
        return elements;
    }
}
