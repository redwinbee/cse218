package p5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class GBag<E extends Comparable<E>> {
    private final Class<E> objClass;
    private E[] array;
    private int capacity;
    private int elements;

    @SuppressWarnings("unchecked")
    public GBag(Class<E> clazz, int capacity) {
        this.array = (E[]) (Array.newInstance(clazz, capacity));
        this.objClass = clazz;
        this.capacity = capacity;
        this.elements = 0;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return elements;
    }

    public void insert(E value) {
        if (elements >= capacity) {
            array = resize();
        }
        array[elements++] = value;
    }

    public Optional<E> remove(E value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (array[i].compareTo(value) == 0) {
                break;
            }
        }

        if (i == elements) {
            return Optional.empty();
        } else {
            E temp = array[i];
            for (int j = i; j < elements - 1; j++) {
                array[j] = array[j + 1];
            }

            elements--;
            return Optional.of(temp);
        }
    }

    @SuppressWarnings("unchecked")
    public E[] find(Predicate<E> predicate) {
        E[] out = (E[]) (Array.newInstance(objClass, elements));
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (predicate.test(array[i])) {
                out[count++] = array[i];
            }
        }

        return Arrays.copyOf(out, count);
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d]: %s%n", i, array[i]);
        }
    }

    public void displayBy(Comparator<E> comparator) {
        Arrays.sort(array, 0, elements, comparator);
        display();
    }

    @SuppressWarnings("unchecked")
    private E[] resize() {
        E[] out = (E[]) Array.newInstance(objClass, capacity * capacity);
        System.arraycopy(array, 0, out, 0, elements);
        this.capacity = out.length;
        return out;
    }
}
