package p3;

public class SimpleLinkedList<T> {
    private Link<T> first;

    public SimpleLinkedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T t) {
        Link<T> newLink = new Link<>(t);
        if (first != null) {
            newLink.setNext(first);
        }
        first = newLink;
    }

    public T remove() {
        Link<T> temp = first;
        first = first.getNext();
        return temp.getT();
    }
}
