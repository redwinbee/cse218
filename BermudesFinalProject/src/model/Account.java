package model;

import util.Generator;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class Account implements Serializable, Comparable<Account> {
    private final UUID uuid;
    private Name name;
    private String userName;
    private String email;
    private String password;

    public Account(Name name, String userName, String email, String password) {
        this.uuid = Generator.createUniqueAccountId();
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
