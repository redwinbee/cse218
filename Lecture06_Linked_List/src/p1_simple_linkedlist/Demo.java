package p1_simple_linkedlist;

public class Demo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Link link1 = new Link(10, new Book("A", "asdfsdfr"));
        Link link2 = new Link(20, new Book("B", "fjisudjf"));
        Link link3 = new Link(30, new Book("C", "sidjf"));
        linkedList.insert(link1);
        linkedList.insert(link2);
        linkedList.insert(link3);

        linkedList.displayList();

        System.out.println("REMOVED");
        Link removed = linkedList.remove();
        linkedList.displayList();
    }
}
