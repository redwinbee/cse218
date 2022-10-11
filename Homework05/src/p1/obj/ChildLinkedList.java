package p1.obj;

import java.util.LinkedList;

public class ChildLinkedList<E extends Child<E>> {
    private final LinkedList<E> childList;
    private final Parent<E> parent;

    public ChildLinkedList(Parent<E> parent) {
        this.childList = new LinkedList<>();
        this.parent = parent;
    }
}
