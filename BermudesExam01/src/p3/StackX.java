package p3;

public class StackX<T> {
    private final SimpleLinkedList<T> list;

    public StackX() {
        this.list = new SimpleLinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(T value) {
        list.add(value);
    }

    public T pop() {
        return list.remove();
    }
}
