package p2;

public class Main2 {
    public static void main(String[] args) {
        int x = 1;
        show(x, 0);
    }

    // when you use recursion you must have a base case otherwise the functions
    // will never stop being placed on the stack which will lead to a StackOverflowError
    private static void show(int x, int count) {
        if (x > 100) { // base case
            return;
        }
        x = 2 * x;
        System.out.printf("[%d]: %s%n", count, x);
        show(x, ++count);
    }
}
