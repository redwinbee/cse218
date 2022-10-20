package p1_intro;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        int[] z = {1, 2, 3, 4};
        show(2);
        show(z);
        System.out.printf("x = %d\ty = %s%n", x, y);
        System.out.println(Arrays.toString(z));
    }

    private static void show(int value) {
        value *= 2;
        System.out.printf("show method is %d%n", value);
    }

    private static void show(int[] values) {
        values[0] = 100;
        System.out.printf("show arrays method: %s%n", Arrays.toString(values));
    }
}

