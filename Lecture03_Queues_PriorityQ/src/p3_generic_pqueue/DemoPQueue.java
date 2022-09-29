package p3_generic_pqueue;

public class DemoPQueue {
    public static void main(String[] args) {
        PQueue<Student> students = new PQueue<>(10);
        students.insert(new Student("M", 4.0));
        students.insert(new Student("Z", 1.0));
        students.insert(new Student("A", 2.5));
    }
}
