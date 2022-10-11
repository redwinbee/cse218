package p1.obj;

public class Parent<E extends Child<E>> {
    private final E value;
    private final ChildLinkedList<E> childList;

    public Parent(E value) {
        this.value = value;
        this.childList = new ChildLinkedList<>(this);
    }
}
