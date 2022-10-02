package p1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GStack<Integer> stack = new GStack<>(Integer.class, 3);
        stack.pushAll(new Integer[]{1, 2, 3, 4});
        System.out.println(stack);

        Integer[] popped = stack.popAll();
        System.out.println(Arrays.toString(popped));
    }
}
