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
        LinkedList<String> emails = readFile("import/emails.txt");
        LinkedList<String> userNames = readFile("import/user_names.txt");
        HashSet<Name> names = importNames();
        Map<UUID, Account> accounts = new TreeMap<>();
        for (int i = 0; i < numAccounts; i++) {
            // create a random account with random values
            Name randName = names.stream().toList().get((int) (Math.random() * names.size()));
            String randUserName = userNames.get((int) (Math.random() * userNames.size()));
            String randEmail = emails.get((int) (Math.random() * emails.size()));
            Account randAcc = new Account(randName, randUserName, randEmail, "password");

            // add some random posts to that account
            LinkedList<Post> randomPosts = generateRandomPosts(randAcc, (int) (Math.random() * RAND_NUM_POSTS_PER_ACC));
            randAcc.setPosts(randomPosts);

            accounts.put(randAcc.getUuid(), randAcc);
        }

        // add the basic account too
        Name name = new Name("John", "Doe");
        Account johnDoeAccount = new Account(name, "johndoe", "johndoe@example.com", "password");
        accounts.put(johnDoeAccount.getUuid(), johnDoeAccount);

        return new AccountsManager(accounts);
    }

    private static LinkedList<Post> generateRandomPosts(Account author, int numPosts) {
        ArrayList<Post> posts = new ArrayList<>();
        ThreadLocalRandom threadedRandom = ThreadLocalRandom.current();

        for (int i = 0; i < numPosts; i++) {
            // Use the ThreadLocalRandom object to generate the number of characters
            int numChars = (int) ((threadedRandom.nextDouble() * RAND_NUM_CHARS_PER_POST) + 32); // at least 32 chars long

            // Use a char array to store the content of the post
            char[] postContent = new char[(int) numChars];

            for (int j = 0; j < numChars; j++) {
                // Generate a random letter and append it to the char array
                postContent[j] = (threadedRandom.nextInt(52) < 26)
                        ? (char) ('A' + threadedRandom.nextInt(26))
                        : (char) ('a' + threadedRandom.nextInt(26));
            }

            posts.add(new Post(author, LocalDateTime.now(), new String(postContent)));
        }

        return posts.parallelStream().collect(Collectors.toCollection(LinkedList::new));
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
