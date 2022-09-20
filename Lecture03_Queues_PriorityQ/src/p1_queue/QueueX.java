package p1_queue;

public class QueueX {
    private final long[] array;
    private final int maxSize;
    private int front;
    private int rear;
    private int elements;

    public QueueX(int maxSize) {
        this.array = new long[maxSize];
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

    public void add(long value) {
        if (rear == maxSize - 1) { // wrap around
            rear = -1;
        }
        array[++rear] = value;
        elements++;
    }

    public long remove() {
        long temp = array[front++];
        if (front == maxSize) { // wrap around
            front = 0;
        }

        elements--;
        return temp;
    }
}
