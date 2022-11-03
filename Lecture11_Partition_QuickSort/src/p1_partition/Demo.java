package p1_partition;

public class Demo {
    public static void main(String[] args) {
        int pivot = 5;
        ArrayPartition array = new ArrayPartition(10);
        array.insert(5);
        array.insert(2);
        array.insert(4);
        array.insert(6);
        array.insert(9);
        array.insert(7);
        array.insert(3);
        array.insert(8);
        array.insert(1);

        array.display();
        int partition = array.partitionIt(0, 7, pivot);
        array.display();
        System.out.println("partition is at " + partition + " for pivot = " + pivot);
    }
}
