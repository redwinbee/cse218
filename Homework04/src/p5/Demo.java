package p5;

import java.util.Arrays;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        GBag<Integer> integers = new GBag<>(Integer.class, 3);
        integers.insert(1);
        integers.insert(2);
        integers.insert(0);
        integers.insert(3);
        integers.insert(2);
        integers.insert(0);
        integers.insert(6);
        integers.insert(0);
        integers.display();

        System.out.println("REMOVE 2");
        Optional<Integer> removed = integers.remove(2);
        integers.display();

        System.out.println("FIND ALL 0's");
        Integer[] zeros = integers.find(integer -> integer == 0);
        System.out.println(Arrays.toString(zeros));
    }
}
