package p3;

import java.util.LinkedList;

public class StackX<E> {
    private final LinkedList<E> stack;

    public StackX() {
        this.stack = new LinkedList<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(E value) {
        stack.push(value);
    }

    public E pop() {
        return stack.pop();
    }
}
