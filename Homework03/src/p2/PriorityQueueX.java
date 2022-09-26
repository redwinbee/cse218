package p2;

import java.util.ArrayList;

public class PriorityQueueX {
    private final ArrayList<Double> array;
    private final int maxSize;
    private int elements;

    public PriorityQueueX(int maxSize) {
        this.array = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
        this.elements = 0;
    }

    public void insert(double value) {
        int j;
        if (elements == 0) {
            array.add(value);
        } else {
            for (j = elements - 1; j >= 0; j--) {
                if (value > array.get(j)) {
                    array.set(j + 1, array.get(j));
                } else {
                    break;
                }
            }
            array.set(j + 1, value);
        }
        elements++;
    }

    public double peek() {
        return array.get(elements - 1);
    }

    public double remove() {
        return array.get(--elements);
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
