package persistence;

import model.Account;
import model.Name;
import model.Post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class Generator {
    private static final int RAND_NUM_POSTS_PER_ACC = 50;
    private static final int RAND_NUM_CHARS_PER_POST = 300;

    private Generator() {
    }

    public static AccountsManager generate(int numAccounts) {
        LinkedList<String> emails = readFile("import/emails.txt");
        LinkedList<String> userNames = readFile("import/user_names.txt");
        HashSet<Name> names = importNames();
        TreeSet<Account> accounts = new TreeSet<>();
        for (int i = 0; i < numAccounts; i++) {
            // create a random account with random values
            Name randName = names.stream().toList().get((int) (Math.random() * names.size()));
            String randUserName = userNames.get((int) (Math.random() * userNames.size()));
            String randEmail = emails.get((int) (Math.random() * emails.size()));
            Account randAcc = new Account(randName, randUserName, randEmail, "password");

            // add some random posts to that account
            LinkedList<Post> randomPosts = generateRandomPosts(randAcc, (int) (Math.random() * RAND_NUM_POSTS_PER_ACC));
            randAcc.setPosts(randomPosts);

            accounts.add(randAcc);
        }

        // add the basic account too
        Name name = new Name("John", "Doe");
        Account johnDoeAccount = new Account(name, "johndoe", "johndoe@example.com", "password");
        accounts.add(johnDoeAccount);

        return new AccountsManager(accounts);
    }

    private static LinkedList<Post> generateRandomPosts(Account author, int numPosts) {
        LinkedList<Post> posts = new LinkedList<>();

        for (int i = 0; i < numPosts; i++) {
            double numChars = (Math.random() * RAND_NUM_CHARS_PER_POST) + 32; // at least 32 chars long
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < numChars; j++) {
                // generate the random letters and append them to the StringBuilder
                char randomLetter = (new Random().nextInt(52) < 26)
                        ? (char) ('A' + new Random().nextInt(26))
                        : (char) ('a' + new Random().nextInt(26));

                sb.append(randomLetter);
            }

            posts.add(new Post(author, LocalDateTime.now(), sb.toString()));
        }

        return posts;
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
