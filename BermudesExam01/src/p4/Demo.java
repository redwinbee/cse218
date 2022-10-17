package p4;

public class Demo {
    public static void main(String[] args) {
        GenericQueueLL<Integer> queue = new GenericQueueLL<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("added 10, 20, 30 to the queue");
        System.out.println("processing queue...");

        int count = 0;
        while (!queue.isEmpty()) {
            System.out.printf("[%d]: %s%n", count++, queue.remove());
        }
    }
}
