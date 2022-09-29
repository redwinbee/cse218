package p2_things_to_know;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Point<Integer> point = new Point<>(1, 2);

        // 1) you cannot create an array of generics
        // Point<Integer>[] array = new Point<>[5];
    }
}
