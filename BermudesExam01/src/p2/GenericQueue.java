package p2;

import java.util.ArrayList;

public class GenericQueue<E> {
    private final ArrayList<E> arrayList;
    private final int maxSize;
    private int front;
    private int rear;
    private int elements;

    public GenericQueue(int maxSize) {
        this.arrayList = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = -1;
        this.elements = 0;
    }

    public boolean isFull() {
        return elements == maxSize;
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public void add(E value) {
        if (rear == maxSize - 1) { // wrap around
            rear = -1;
        }
        arrayList.add(++rear, value);
        elements++;
    }

    public E remove() {
        E temp = arrayList.get(front++);
        if (front == maxSize) { // wrap around
            front = 0;
        }

        elements--;
        return temp;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d]: %s%n", i, arrayList.get(i));
        }
    }
}