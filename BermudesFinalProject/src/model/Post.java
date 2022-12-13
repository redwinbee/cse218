package model;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Post implements Serializable {
    private final Account author;
    private final ConcurrentLinkedQueue<PostComment> comments;
    private final LocalDateTime timePosted;
    private final String body;
    private File attachment;

    public Post(Account author, LocalDateTime timePosted, String body) {
        this.author = author;
        this.comments = new ConcurrentLinkedQueue<>();
        this.timePosted = timePosted;
        this.body = body;
    }

    public Post(Account author, LocalDateTime timePosted, String body, File attachment) {
        this.author = author;
        this.comments = new ConcurrentLinkedQueue<>();
        this.timePosted = timePosted;
        this.body = body;
        this.attachment = attachment;
    }

    public Account getAuthor() {
        return author;
    }

    public LocalDateTime getTimePosted() {
        return timePosted;
    }

    public String getBody() {
        return body;
    }

    public File getAttachment() {
        return attachment;
    }

    public ConcurrentLinkedQueue<PostComment> getComments() {
        return comments;
    }

    public void addComment(Account commenter, String body) {
        comments.add(new PostComment(commenter, LocalDateTime.now(), body));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("author=" + author)
                .add("timePosted=" + timePosted)
                .add("body='" + body + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) && Objects.equals(timePosted, post.timePosted) && Objects.equals(body, post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, timePosted, body);
    }
}
