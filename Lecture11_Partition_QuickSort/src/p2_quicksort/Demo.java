package p2_quicksort;

public class Demo {
    public static void main(String[] args) {
        ArrayQuick array = new ArrayQuick(20);
        array.insert(5);
        array.insert(6);
        array.insert(1);
        array.insert(2);
        array.insert(8);
        array.insert(3);
        array.insert(7);
        array.insert(4);

        array.display();
        array.quickSort();
        array.display();
    }
}
