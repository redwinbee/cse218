package p3;

public class Demo {
    public static void main(String[] args) {
        StackX<Integer> stack = new StackX<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pushed 1, 2, 3 onto stack");
        System.out.println("Popping all...");

        int count = 0;
        while (!stack.isEmpty()) {
            System.out.printf("[%d]: %s%n", count++, stack.pop());
        }
    }
}
