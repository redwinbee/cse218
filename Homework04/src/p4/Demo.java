package p4;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        NumberBag<Integer> doubleBag = new NumberBag<>(5);
        for (int i = 0; i < 5; i++) {
            doubleBag.insert((int) (Math.random() * 10));
        }
        // remove & display
        System.out.println("BEFORE");
        doubleBag.display();
        doubleBag.remove(7);
        System.out.println("AFTER");
        doubleBag.display();

        // find
        Optional<Integer> found = doubleBag.find(5);
        System.out.printf("[find(5)]: value %s", (found.isPresent()) ? String.format("found: %d", found.get()) : "not found");
    }
}
