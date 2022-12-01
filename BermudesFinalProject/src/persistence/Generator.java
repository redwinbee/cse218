package persistence;

import model.Account;
import model.Name;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Generator {
    private Generator() {
    }

    public static AccountsManager generate(int numAccounts) {
        LinkedList<String> emails = readFile("import/emails.txt");
        LinkedList<String> userNames = readFile("import/user_names.txt");
        HashSet<Name> names = importNames();
        TreeSet<Account> accounts = new TreeSet<>();
        for (int i = 0; i < numAccounts; i++) {
            accounts.add(new Account(names.stream().toList().get((int) (Math.random() * names.size())),
                    userNames.get((int) (Math.random() * userNames.size())),
                    emails.get((int) (Math.random() * emails.size())),
                    "password"));
        }

        // add the basic account too
        accounts.add(new Account(
                new Name("John", "Doe"), "johndoe", "johndoe@example.com", "password"));
        return new AccountsManager(accounts);
    }


    private static HashSet<Name> importNames() {
        LinkedList<String> firstNames = readFile("import/first_names.txt");
        LinkedList<String> lastNames = readFile("import/last_names.txt");
        HashSet<Name> names = HashSet.newHashSet(firstNames.size());
        for (int i = 0; i < firstNames.size(); i++) {
            String randFirst = firstNames.get((int) (Math.random() * firstNames.size()));
            String randLast = lastNames.get((int) (Math.random() * lastNames.size()));
            names.add(new Name(randFirst, randLast));
        }

        return names;
    }

    private static LinkedList<String> readFile(String fileName) {
        LinkedList<String> out = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String curr;
            while ((curr = reader.readLine()) != null) {
                out.add(curr);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return out;
    }
}
