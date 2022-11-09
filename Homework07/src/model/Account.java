package model;

import util.Generator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class Account implements Serializable, Comparable<Account> {
    private final ArrayList<Post> posts;

    private final UUID uuid;
    private String email;
    private Name name;
    private String username;
    private String password;

    public Account(String email, Name name, String username, String password) {
        this.uuid = Generator.createUniqueAccountId();
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
        this.posts = new ArrayList<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    @Override
    public int compareTo(Account other) {
        return username.compareTo(other.getUsername());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("uuid=" + uuid)
                .add("email='" + email + "'")
                .add("username='" + username + "'")
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
