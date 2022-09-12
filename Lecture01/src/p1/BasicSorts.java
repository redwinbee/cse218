package p1;

public class BasicSorts {
    private final int[] arr;
    private final int elements;

    public BasicSorts(int initialSize) {
        this.arr = new int[initialSize];
        this.elements = 0;
    }
    public void insertionSort() {
        int in;
        int out;
        for(out = 1; out < elements; out++) {
            int temp = arr[out];
            in = out;
            while(in > 0 && arr[in-1] > temp) {
                arr[in] = arr[in-1];
                in--;
            }
            arr[in] = temp;
        }
    }

    public void selectionSort() {
        int out;
        int in;
        int min;
        for(out = 0; out < elements - 1; out++) {
            min = out;
            for(in = out+1; in < elements; in++) {
                if(arr[in] < arr[min]) {
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    public void bubbleSort() {
        int out;
        int in;
        for (out = elements - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if(arr[in] > arr[in + 1]) {
                    swap(in, in+1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
