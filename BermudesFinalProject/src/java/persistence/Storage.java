package persistence;

import model.Account;

import java.io.*;
import java.util.Collection;

public class Storage {
    public static final File ACCOUNTS_FILE = new File("data/accounts.dat");

    public static void backup(Collection<Account> accounts) {
        System.out.printf("[storage]: backing up %d account(s)...%n", accounts.size());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNTS_FILE))) {
            oos.writeObject(accounts);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked") //TODO possibly a better way to handle this
    public static Collection<Account> restore() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ACCOUNTS_FILE))) {
            Collection<Account> accounts = (Collection<Account>) ois.readObject();

            System.out.printf("[storage]: restoring %d account(s)...%n", accounts.size());
            return accounts;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
