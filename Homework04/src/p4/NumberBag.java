package p4;

import java.util.ArrayList;
import java.util.Optional;

public class NumberBag<E extends Number> {
    private final ArrayList<E> arrayList;

    public NumberBag(int initialCapacity) {
        this.arrayList = new ArrayList<>(initialCapacity);
    }

    public void insert(E number) {
        arrayList.add(number);
    }

    public E remove(E number) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(number)) {
                return arrayList.remove(i);
            }
        }

        return null;
    }

    public Optional<E> find(E number) {
        for (E value : arrayList) {
            if (value.equals(number)) {
                return Optional.of(value);
            }
        }

        return Optional.empty();
    }

    public void display() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("[%d]: %s%n", i, arrayList.get(i));
        }
    }
}
