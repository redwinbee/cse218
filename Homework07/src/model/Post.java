package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class Post implements Serializable {
    private final Account author;
    private final LocalDateTime timePosted;
    private String body;

    public Post(Account author, String body) {
        this.author = author;
        this.body = body;
        this.timePosted = LocalDateTime.now();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("author=" + author)
                .add("body='" + body + "'")
                .add("timePosted=" + timePosted)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) && Objects.equals(timePosted, post.timePosted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, timePosted);
    }
}
