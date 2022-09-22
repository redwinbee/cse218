package p1_priority_queue;

public class DemoPQueue {
    public static void main(String[] args) {
        PQueue queue = new PQueue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(50);
        queue.insert(70);
        queue.insert(30);

        while (!queue.isEmpty()) {
            System.out.println("removed: " + queue.remove());
        }
    }
}
