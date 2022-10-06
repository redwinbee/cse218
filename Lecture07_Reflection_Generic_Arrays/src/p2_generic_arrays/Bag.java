package p2_generic_arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;

public class Bag<E> {
    private final Class<E> clazz;
    private int maxSize;
    private E[] array;
    private int elements;

    @SuppressWarnings("unchecked")
    public Bag(Class<E> clazz, int maxSize) {
        this.array = (E[]) Array.newInstance(clazz, maxSize);
        this.maxSize = maxSize;
        this.clazz = clazz;
        this.elements = 0;
    }

    public void insert(E value) {
        if (elements >= maxSize) {
            array = resize();
        }
        array[elements++] = value;
    }

    public void insertAll(E[] values) {
        for (E value : values) {
            insert(value);
        }
    }

    @SuppressWarnings("unchecked")
    public E[] search(Predicate<E> predicate) {
        E[] out = (E[]) Array.newInstance(clazz, elements);
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

    @SuppressWarnings("unchecked")
    private E[] resize() {
        E[] out = (E[]) Array.newInstance(clazz, maxSize * maxSize);
        System.arraycopy(array, 0, out, 0, elements);
        this.maxSize = out.length;
        return out;
    }
}
