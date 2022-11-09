package persistence;

import model.Account;

import java.util.Collection;
import java.util.UUID;

public class AccountsManager {
    private final Collection<Account> accounts;

    public AccountsManager(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    public Collection<Account> all() {
        return accounts;
    }

    public boolean exists(Account account) {
        return accounts.stream().anyMatch(acc ->
                acc.getEmail().equals(account.getEmail()) || acc.getUsername().equals(account.getUsername()));
    }

    public boolean exists(UUID uuid) {
        return accounts.stream().anyMatch(acc -> acc.getUuid().equals(uuid));
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
}
