package persistence;

import model.Account;
import model.Name;
import model.Post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Generator {
    private static final int RAND_NUM_POSTS_PER_ACC = 50;
    private static final int RAND_NUM_CHARS_PER_POST = 300;

    private Generator() {
    }

    public static AccountsManager generate(int numAccounts) {
        List<String> emails = new ArrayList<>(readFile("import/emails.txt"));
        List<String> userNames = new ArrayList<>(readFile("import/user_names.txt"));
        List<Name> names = importNames().stream().toList();

        ThreadLocalRandom threadedRandom = ThreadLocalRandom.current();
        Map<String, Account> accounts = new TreeMap<>();
        for (int i = 0; i < numAccounts; i++) {
            // create a random account with random values
            Name randName = names.get(threadedRandom.nextInt(names.size()));
            String randUserName = userNames.get(threadedRandom.nextInt(userNames.size()));
            String randEmail = emails.get(threadedRandom.nextInt(emails.size()));
            Account randAcc = new Account(randName, randUserName, randEmail, "password");

            // add some random posts to that account
            LinkedList<Post> randomPosts = generateRandomPosts(randAcc, threadedRandom.nextInt(RAND_NUM_POSTS_PER_ACC));
            randAcc.setPosts(randomPosts);

            accounts.put(randAcc.getUserName(), randAcc);
        }

        // add the basic account too
        Name name = new Name("John", "Doe");
        Account johnDoeAccount = new Account(name, "johndoe", "johndoe@example.com", "password");
        accounts.put(johnDoeAccount.getUserName(), johnDoeAccount);

        return new AccountsManager(accounts);
    }


    private static LinkedList<Post> generateRandomPosts(Account author, int numPosts) {
        ArrayList<Post> posts = new ArrayList<>();
        ThreadLocalRandom threadedRandom = ThreadLocalRandom.current();

        for (int i = 0; i < numPosts; i++) {
            int numChars = (int) ((threadedRandom.nextDouble() * RAND_NUM_CHARS_PER_POST) + 32); // at least 32 chars long

            StringBuilder out = new StringBuilder();
            for (int j = 0; j < numChars; j++) {
                out.append((threadedRandom.nextInt(52) < 26)
                        ? (char) ('A' + threadedRandom.nextInt(26))
                        : (char) ('a' + threadedRandom.nextInt(26)));
            }

            posts.add(new Post(author, LocalDateTime.now(), out.toString()));
        }

        return posts.parallelStream().collect(Collectors.toCollection(LinkedList::new));
    }


    private static HashSet<Name> importNames() {
        List<String> firstNames = new ArrayList<>(readFile("import/first_names.txt"));
        List<String> lastNames = new ArrayList<>(readFile("import/last_names.txt"));
        ThreadLocalRandom threadedRandom = ThreadLocalRandom.current();
        HashSet<Name> names = new HashSet<>();
        for (int i = 0; i < firstNames.size(); i++) {
            String randFirst = firstNames.get(threadedRandom.nextInt(firstNames.size()));
            String randLast = lastNames.get(threadedRandom.nextInt(lastNames.size()));
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
