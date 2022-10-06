package p1_simple_linkedlist;

public class LinkedList {
    private Link first;

    public LinkedList() {
        super();
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

    public Link remove() {
        Link temp = first;
        first = first.getNext();
        return temp;
    }

    public void displayList() {
        System.out.println("First link => Last link");
        Link curr = first;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.getNext();
        }
    }
}
