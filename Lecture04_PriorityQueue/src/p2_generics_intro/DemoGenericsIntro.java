package p2_generics_intro;

import java.util.ArrayList;

@SuppressWarnings("all")
public class DemoGenericsIntro {
    public static void main(String[] args) {
//        ArrayList<int> list1 = new ArrayList<int>(); <- can't do this since generics require reference types
//        ArrayList<Integer> list1 = new ArrayList<>(); <- this is okay

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
//        stringList.add(1); <- can't do this, this list is only for strings

        /**
         * you can cirumvent the generics type checking by not using the angle brackets, however
         * this is not recommended as it can lead to errors when working with mixed data this way.
         *
         * BAD
         */
        ArrayList anythingList = new ArrayList();
        anythingList.add(1);
        anythingList.add("A");
        anythingList.add(0x54F);


    }
}
