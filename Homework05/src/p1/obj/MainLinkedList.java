package p1.obj;

import java.util.LinkedList;

public class MainLinkedList {
    private final LinkedList<Link> mainList;

    public MainLinkedList() {
        this.mainList = new LinkedList<>();
    }

    public void add(String word) {
        Link newLink = new Link(word);
        mainList.add(newLink);
    }

    public Link search(String word) {
        for (Link link : mainList) {
            if (link.getValue().equals(word)) {
                return link;
            }
        }

        // no match, unique word
        return null;
    }
}
