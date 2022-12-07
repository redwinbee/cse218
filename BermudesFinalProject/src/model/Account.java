package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class Account implements Serializable, Comparable<Account> {
    private final HashSet<Account> subscribers;
    private final Name name;
    private final String userName;
    private final String email;
    private final String password;
    private LinkedList<Post> posts;

    public Account(Name name, String userName, String email, String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.posts = new LinkedList<>();
        this.subscribers = new HashSet<>();
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
        return this.userName.compareTo(other.getUserName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("name=" + name)
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(userName, account.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
