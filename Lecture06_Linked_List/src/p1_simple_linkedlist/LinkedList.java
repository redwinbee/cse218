package p1_simple_linkedlist;

public class LinkedList {
    private Link first;

    public LinkedList(Link first) {
        this.first = null;
    }

    public void insert(Link newLink) {
        if (first == null) {
            first = newLink;
        } else {
            newLink.setNext(first);
            first = newLink;
        }
    }
}
