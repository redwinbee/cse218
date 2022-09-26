package p1;

import java.util.ArrayList;

public class QueueX {
    private final ArrayList<String> array;
    private final int maxSize;
    private int elements;
    private int front;
    private int rear;

    public QueueX(int maxSize) {
        this.array = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
        this.elements = 0;
        this.front = 0;
        this.rear = -1;
    }

    public boolean isFull() {
        return elements == maxSize;
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public void add(String value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }

        array.add(value);
        elements++;
    }

    public String remove() {
        String temp = array.get(front++);
        if (front == maxSize) {
            front = 0;
        }

        elements--;
        return temp;
    }
}
