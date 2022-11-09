package persistence;

import model.Account;

import java.io.*;
import java.util.Collection;

public class Storage {
    public static final File ACCOUNTS_FILE = new File("data/accounts.dat");

    public static void backup(AccountsManager accountsManager) {
        Collection<Account> accounts = accountsManager.all();
        System.out.printf("[storage]: backing up %d account(s)...%n", accounts.size());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNTS_FILE))) {
            oos.writeObject(accounts);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked") //TODO possibly a better way to handle this
    public static AccountsManager restore() {
        AccountsManager accountsManager;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ACCOUNTS_FILE))) {
            accountsManager = new AccountsManager((Collection<Account>) ois.readObject());

            System.out.printf("[storage]: restoring %d account(s)...%n", accountsManager.size());
            return accountsManager;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
