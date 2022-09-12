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
