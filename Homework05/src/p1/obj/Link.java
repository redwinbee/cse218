package p1.obj;

import java.util.LinkedList;

public class Link {
    private final String value;
    private final LinkedList<String> children;

    public Link(String value) {
        this.value = value;
        this.children = new LinkedList<>();
    }

    public String getValue() {
        return value;
    }

    public LinkedList<String> getChildren() {
        return children;
    }
}
