package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PostComment implements Serializable {
    private final Account author;
    private final LocalDateTime timeCommented;
    private final String body;

    public PostComment(Account author, LocalDateTime timeCommented, String body) {
        this.author = author;
        this.timeCommented = timeCommented;
        this.body = body;
    }

    public Account getAuthor() {
        return author;
    }

    public LocalDateTime getTimeCommented() {
        return timeCommented;
    }

    public String getBody() {
        return body;
    }
}
