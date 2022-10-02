package p1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringJoiner;

public class GStack<E> {
    private final E[] array;
    private final int maxSize;
    private int top;

    @SuppressWarnings("unchecked")
    public GStack(Class<E> clazz, int maxSize) {
        this.array = (E[]) Array.newInstance(clazz, maxSize);
        this.maxSize = maxSize;
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(E value) {
        array[++top] = value;
    }

    public E pop() {
        return array[top--];
    }

    public E peek() {
        return array[top];
    }

    public void pushAll(E[] values) {
        for (E value : values) {
            if (!this.isFull()) {
                this.push(value);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public E[] popAll() {
        E[] out = (E[]) Array.newInstance(array[0].getClass(), maxSize);
        int idx = 0;
        while (!this.isEmpty()) {
            out[idx++] = this.pop();
        }

        return out;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GStack.class.getSimpleName() + "", "")
                .add(Arrays.toString(array))
                .toString();
    }
}
