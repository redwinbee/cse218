package p1;

import java.util.StringJoiner;

public class Book {
    private static int isbnCounter;
    private final String isbn;
    private String title;
    private Author author;
    private double price;

    public Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = String.valueOf(isbnCounter++);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("isbn='" + isbn + "'")
                .add("title='" + title + "'")
                .add("author=" + author)
                .add("price=" + price)
                .toString();
    }
}
