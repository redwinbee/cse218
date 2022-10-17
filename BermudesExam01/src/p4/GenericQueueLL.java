package p4;

import java.util.LinkedList;

public class GenericQueueLL<E> {
    private final LinkedList<E> list;
    private int elements;

    public GenericQueueLL() {
        this.list = new LinkedList<>();
        this.elements = 0;
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public int size() {
        return elements;
    }

    public void add(E value) {
        list.add(value);
        elements++;
    }

    public E remove() {
        E temp = list.remove();
        elements--;
        return temp;
    }
}
