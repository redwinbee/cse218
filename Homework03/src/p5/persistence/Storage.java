package p5.persistence;

import p5.model.Account;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    public static final File ACCOUNTS_FILE = new File("accounts.dat");

    public static void backup(ArrayList<Account> accounts) {
        System.out.printf("[storage]: backing up %d accounts...%n", accounts.size());
        try {
            FileOutputStream fos = new FileOutputStream(ACCOUNTS_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(accounts);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Account> restore() {
        try {
            FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Account> accounts = (ArrayList<Account>) ois.readObject();
            ois.close();

            System.out.printf("[storage]: restoring %d accounts...%n", accounts.size());
            return accounts;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
