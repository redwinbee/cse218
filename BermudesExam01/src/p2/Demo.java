package p2;

public class Demo {
    public static void main(String[] args) {
        GenericQueue<Book> queue = new GenericQueue<>(3);
        queue.add(new Book("A", 1.00));
        queue.add(new Book("B", 2.50));
        queue.add(new Book("C", 3.75));


        queue.display();

        int count = 0;
        while (!queue.isEmpty()) {
            Book removed = queue.remove();
            System.out.printf("[%d]: removed: %s%n", count++, removed);
        }
    }
}
