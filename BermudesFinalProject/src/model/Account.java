package model;

import java.io.Serializable;
import java.util.*;

public class Account implements Serializable, Comparable<Account> {
    private final UUID uuid;
    private final HashSet<Account> subscribers;
    private final Name name;
    private final String userName;
    private final String email;
    private final String password;
    private LinkedList<Post> posts;

    public Account(Name name, String userName, String email, String password) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.posts = new LinkedList<>();
        this.subscribers = new HashSet<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Name getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LinkedList<Post> getPosts() {
        return posts;
    }

    public void setPosts(LinkedList<Post> randomPosts) {
        this.posts = randomPosts;
    }

    public HashSet<Account> getSubscribers() {
        return subscribers;
    }

    @Override
    public int compareTo(Account other) {
        return this.uuid.compareTo(other.getUuid());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("name=" + name)
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .add("uuid=" + uuid)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(uuid, account.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
