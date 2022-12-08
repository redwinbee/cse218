package persistence;

import model.Account;
import model.Name;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class AccountsManager {
    private final Map<String, Account> accounts;

    public AccountsManager(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Optional<Account> verifyCredentials(String userName, String password) {
        ;
        return accounts.values().stream()
                .filter(acc -> acc.getUserName().equals(userName) && acc.getPassword().equals(password))
                .findAny();
    }

    public Map<String, Account> all() {
        return accounts;
    }

    public boolean exists(String userName) {
        return accounts.containsKey(userName);
    }

    public Optional<Account> create(Name name, String userName, String email, String password) {
        if (exists(userName)) {
            return Optional.empty();
        } else {
            Account account = new Account(name, userName, email, password);
            add(account);
            return Optional.of(account);
        }
    }

    public void add(Account account) {
        accounts.put(account.getUserName(), account);
    }

    public int size() {
        return accounts.size();
    }

    public void display() {
        Iterator<Account> iter = accounts.values().iterator();
        int count = 0;
        while (iter.hasNext()) {
            System.out.printf("[%d]: %s%n", count++, iter.next());
        }
    }
}
