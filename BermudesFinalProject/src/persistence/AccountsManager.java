package persistence;

import model.Account;
import model.Name;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

public class AccountsManager {
    private final Collection<Account> accounts;

    public AccountsManager(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    public Optional<Account> verifyCredentials(String userName, String password) {
        return accounts.stream()
                .filter(acc -> acc.getUserName().equals(userName) && acc.getPassword().equals(password))
                .findAny();
    }

    public Collection<Account> all() {
        return accounts;
    }

    public boolean exists(UUID uuid) {
        return accounts.stream().anyMatch(acc -> acc.getUuid().equals(uuid));
    }

    public boolean exists(String userName, String email) {
        return accounts.stream().anyMatch(acc ->
                acc.getUserName().equals(userName) || acc.getEmail().equals(email));
    }

    public Optional<Account> create(Name name, String userName, String email, String password) {
        if (exists(userName, email)) {
            return Optional.empty();
        } else {
            Account account = new Account(name, userName, email, password);
            add(account);
            return Optional.of(account);
        }
    }

    public void add(Account account) {
        accounts.add(account);
    }

    public void remove(Account account) {
        accounts.remove(account);
    }

    public int size() {
        return accounts.size();
    }

    public void display() {
        Iterator<Account> iter = accounts.iterator();
        int count = 0;
        while (iter.hasNext()) {
            System.out.printf("[%d]: %s%n", count++, iter.next());
        }
    }
}
