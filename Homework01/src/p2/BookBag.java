package p2;

import p1.Book;

import java.util.Arrays;

public class BookBag {
    private Book[] arr;
    private int elements;

    public BookBag(int initialSize) {
        this.arr = new Book[initialSize];
    }

    public void insert(Book book) {
        if (elements >= arr.length) {
            arr = resize();
        }
        arr[elements++] = book;
    }

    public Book deleteByIsbn(String isbn) {
        int i;
        for (i = 0; i < elements; i++) {
            if (arr[i].getIsbn().equals(isbn)) {
                break;
            }
        }

        if (i == elements) {
            return null;
        } else {
            Book temp = arr[i];
            for (int j = 0; j < elements - 1; j++) {
                arr[j] = arr[j + 1];
            }

            elements--;
            return temp;
        }
    }

    public Book[] deleteByLastName(String lastName) {
        Book[] matches = new Book[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (arr[i].getAuthor().getLastName().equals(lastName)) {
                matches[count++] = arr[i];
                for (int j = i; j < elements - 1; j++) {
                    arr[j] = arr[j + 1];
                }

                elements--;
                i--;
            }
        }

        return Arrays.copyOf(matches, count);
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d]: %s%n", i, arr[i]);
        }
    }

    public Book sequentialSearchByISBN(String isbn) {
        for (int i = 0; i < elements; i++) {
            if (arr[i].getIsbn().equals(isbn)) {
                return arr[i];
            }
        }

        return null;
    }

    public Book binarySearchByISBN(String isbn) {
        int lower = 0;
        int upper = arr.length;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (arr[middle].getIsbn().equals(isbn)) {
                return arr[middle];
            } else if ((Integer.parseInt(arr[middle].getIsbn()) > Integer.parseInt(isbn))) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }

        return null;
    }

    public Book[] sequentialSearchByLastName(String lastName) {
        Book[] out = new Book[arr.length];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (arr[i].getAuthor().getLastName().equals(lastName)) {
                out[count++] = arr[i];
            }
        }

        return Arrays.copyOf(out, count);
    }

    public void bubbleSortByIsbn() {
        int out;
        int in;
        for (out = elements - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (Integer.parseInt(arr[in].getIsbn()) > Integer.parseInt(arr[in + 1].getIsbn())) {
                    swap(in, in + 1);
                }
            }
        }
    }

    public void insertionSortByLastName() {
        int in;
        int out;
        for (out = 1; out < elements; out++) {
            Book temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1].getAuthor().getLastName().compareTo(temp.getAuthor().getLastName()) > 0) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
    }

    public void selectionSortByPrice() {
        int out;
        int in;
        int min;
        for (out = 0; out < elements - 1; out++) {
            min = out;
            for (in = out + 1; in < elements; in++) {
                if (arr[in].getPrice() < arr[min].getPrice()) {
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    private Book[] resize() {
        Book[] out = new Book[arr.length + 10];
        System.arraycopy(arr, 0, out, 0, arr.length);
        return out;
    }

    private void swap(int book1Idx, int book2Idx) {
        Book temp = arr[book1Idx];
        arr[book1Idx] = arr[book2Idx];
        arr[book2Idx] = temp;
    }
}
