package p1_simple_linkedlist;

import java.util.StringJoiner;

public class Link {
    private int data;
    private Book book;
    private Link next;

    public Link(int data, Book book) {
        this.data = data;
        this.book = book;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Link.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("book=" + book)
                .toString();
    }
}
