package p3_generic_pqueue;

import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class PQueue<E extends Comparable> {
    private final E[] queArray;
    private final int maxSize;
    private int nElems;

    @SuppressWarnings("unchecked")
    public PQueue(int maxSize) {
        this.maxSize = maxSize;
        queArray = (E[]) new Object[maxSize];
        nElems = 0;
    }

    @SuppressWarnings("unchecked")
    public void insert(E value) {
        int j;
        if (nElems == 0) { // empty
            queArray[0] = value;
        } else { // not empty
            for (j = nElems - 1; j >= 0; j--) {
                if (value.compareTo(queArray[j]) > 0) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j + 1] = value;
        }
        nElems++;
    }

    public E peekMin() {
        return queArray[nElems - 1];
    }

    public E remove() {
        return queArray[--nElems];
    }

    public int size() {
        return nElems;
    }

    public boolean isFull() {
        return nElems == maxSize;
    }

    public boolean isEmpty() {
        return nElems == 0;
    }

}
