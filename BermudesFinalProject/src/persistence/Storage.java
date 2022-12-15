package persistence;

import model.Account;

import java.io.*;
import java.util.HashSet;
import java.util.Map;

public class Storage {
    public static final File ACCOUNTS_FILE = new File("data/accounts.ser");
    public static final File DICTIONARY_FILE = new File("import/dictionary.txt");
    public static final HashSet<String> DICTIONARY = new HashSet<>(100_000);

    static {
        loadDictionary();
    }

    private Storage() {
    }

    public static void backup(AccountsManager accountsManager) {
        Map<String, Account> accounts = accountsManager.all();
        System.out.printf("[storage]: backing up %d account(s)...%n", accounts.size());
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(ACCOUNTS_FILE));
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(accounts);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked") //TODO possibly a better way to handle this
    public static AccountsManager restore() {
        AccountsManager accountsManager;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(ACCOUNTS_FILE));
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            Map<String, Account> accounts = (Map<String, Account>) ois.readObject();
            accountsManager = new AccountsManager(accounts);

            System.out.printf("[storage]: restoring %d account(s)...%n", accountsManager.size());
            return accountsManager;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private static void loadDictionary() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DICTIONARY_FILE))) {
            String curr;
            while ((curr = reader.readLine()) != null) {
                DICTIONARY.add(curr);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("[storage]: loaded dictionary");
    }
}
