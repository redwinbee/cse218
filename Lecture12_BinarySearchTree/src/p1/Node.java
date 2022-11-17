package p1;

public class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.printf("[Node]: { iData='%s', dData='%.1f' }%n", iData, dData);
    }
}
