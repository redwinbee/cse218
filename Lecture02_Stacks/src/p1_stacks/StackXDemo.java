package p1_stacks;

public class StackXDemo {
    public static void main(String[] args) {
        StackX myStack = new StackX(5);
        while (!myStack.isFull()) {
            myStack.push((long) (Math.random() * 10));
        }

        System.out.println("peek: " + myStack.peek());
        System.out.println();

        while (!myStack.isEmpty()) {
            System.out.println("pop: " + myStack.pop());
        }
    }
}
