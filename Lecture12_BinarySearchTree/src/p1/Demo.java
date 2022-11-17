package p1;

public class Demo {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5, 5.5);
        tree.insert(3, 3.3);
        tree.insert(7, 7.5);
        tree.insert(4, 5.5);
        tree.insert(10, 3.3);
        tree.insert(12, 7.5);
        tree.insert(8, 5.5);
        tree.insert(15, 3.3);
        tree.insert(7, 1.1);
        tree.insert(10, 5.2);

        tree.minimum().displayNode();
        tree.maximum().displayNode();

        tree.traverse(2);
        tree.find(10).displayNode(); // only the first match will be returned
        System.out.println("[removed]: result of trying to remove '12': " + tree.remove(12));
        tree.traverse(2);
    }
}
