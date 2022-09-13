package p3;

import p1.Author;
import p1.Book;
import p2.BookBag;

public class Demo {
    private static BookBag bookBag;
    public static void main(String[] args) {
        bookBag = new BookBag(5);
        bookBag.insert(new Book("A", new Author("John", "Doe"), 9.99));
        bookBag.insert(new Book("B", new Author("Jane", "Doe"), 10.99));
        bookBag.insert(new Book("C", new Author("Edwin", "Bermudes"), 7.99));
        bookBag.insert(new Book("D", new Author("Adam", "Smith"), 6.99));
        bookBag.insert(new Book("A", new Author("Claire", "Brooks"), 12.99));

        // DISPLAY
        System.out.println("================= BEFORE =================\n");
        bookBag.display();

        runSorts();
        runSearches();
        runDeletions();

        System.out.println("\n================= AFTER =================");
        bookBag.display();
    }

    private static void runSorts() {
        // INSERTION SORT (BY LAST NAME)
        System.out.println("--- INSERTION SORT (BY LAST NAME) ---");
        bookBag.insertionSortByLastName();
        bookBag.display();

        // BUBBLE SORT (BY ISBN)
        System.out.println("--- BUBBLE SORT (BY ISBN) ---");
        bookBag.bubbleSortByIsbn();
        bookBag.display();

        // SELECTION SORT (BY PRICE)
        System.out.println("--- SELECTION SORT (BY PRICE) ---");
        bookBag.selectionSortByPrice();
        bookBag.display();
    }

    private static void runSearches() {
        // SEQUENTIAL SEARCH (BY ISBN)
        System.out.println("--- SEQUENTIAL SEARCH (BY ISBN == 3) ---");
        Book sequentialBook = bookBag.sequentialSearchByISBN("3");
        display(sequentialBook);

        // BINARY SEARCH (BY ISBN)
        System.out.println("--- BINARY SEARCH (BY ISBN == 0) ---");
        Book binaryBook = bookBag.binarySearchByISBN("0");
        display(binaryBook);

        // SEQUENTIAL SEARCH (BY LAST NAME == "Doe")
        System.out.println("--- SEQUENTIAL SEARCH (BY LAST NAME == \"Doe\") ---");
        Book[] seqBookByName = bookBag.sequentialSearchByLastName("Doe");
        display(seqBookByName);
    }

    private static void runDeletions() {
        // DELETE (BY ISBN = 2)
        System.out.println("--- DELETE (BY ISBN = 2) ---");
        Book deletedByIsbn = bookBag.deleteByIsbn("2");
        display(deletedByIsbn);

        // DELETE (BY LAST NAME = "Bermudes")
        System.out.println("--- DELETE (BY LAST NAME = \"Bermudes\") ---");
        Book[] deletedByLastName = bookBag.deleteByLastName("Bermudes");
        display(deletedByLastName);
    }

    private static void display(Book... books) {
        for (int i = 0; i < books.length; i++) {
            System.out.printf("[%d]: %s%n", i, books[i]);
        }
    }
}
