package p1_stacks;

public class StackX {
    private final long[] stackArray;
    private final int maxSize;
    private int top;

    public StackX(int maxSize) {
        this.stackArray = new long[maxSize];
        this.maxSize = maxSize;
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(long value) {
        stackArray[++top] = value;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }
}
