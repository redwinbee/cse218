package p1_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        Iterator<Integer> iter1 = list1.iterator();
        //iter1.forEachRemaining(integer -> System.out.println(integer)); // better version below using method ref
        iter1.forEachRemaining(System.out::println);
        // notice that this does not print "1, 2, 3" again because the cursor of the iterator (iter1) is already at
        // the end. thus if we wanted to print it again we would have to reset the cursor by means of destroying this
        // iterator and creating a new one. you *can* use previous method to go backwards but that is nonsensical in the
        // case where all you want is to go back to the beginning since that is a log(n) operator when creating a new
        // iterator that *already* starts at the beginning of the first element is log(1).
        //
        // YOU CAN ONLY GO BACK USING ListIterator AND NOT Iterator.
        iter1.forEachRemaining(System.out::println);

        System.out.println("=======");

        // Now this is the actual Iterator we usually use when working with collections since it is more powerful and
        // allows modifying the data in-place during iteration
        ListIterator<Integer> iter2 = list1.listIterator();
        iter2.next();
        iter2.set(10);
        iter2.previous();
        iter2.forEachRemaining(System.out::println);

        System.out.println("=======");

        boolean hasNum2 = list1.contains(2);
        System.out.printf("list has number 2? %s%n", hasNum2);
    }
}
