package p3_generic_methods;

import java.util.Arrays;

public class DemoGenericMethods {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5}; // boxed as Integer objects
        Character[] array2 = {'A', 'B', 'C', 'D'}; // boxed as Character objects
        Student[]  students = {new Student("A", 3.0), new Student("D", 2.4), new Student("B", 4.0)};
        showIntegerArray(array1);
//         showIntegerArray(array2); <- only accepts Integer objects
        showCharacterArray(array2);
//        showCharacterArray(array1); <- only accepts Character objects

        /*
        when we go to use this method we ask the compiler to fill in the type at
        compile-time, meaning that it won't have any affect during run-time since
        the Erasure happens at compile-time.
         */
        //showArray(array1);
        //showArray(array2);
        showArray(students);

        System.out.println("BEFORE SORT BY NAME");
        showArray(students);

        System.out.println("SORTED BY NAME");
        Arrays.sort(students);
        showArray(students);
    }

    /**
     * we can also constrain our generic if we want to accept a wide variety of data,
     * but our method might do something that only works with certain types of data. In this
     * case we have a type that must extend Number.
     *
     * <p></p>
     *
     * we could also have <E extends Comparable> which would mean that we only want to work
     * with data that can be compared.
     */
    private static <E extends Number> void showNumArray(E[] array) {
        // do whatever here
    }

    /**
     * you can have multiple generic types in a single method
     */
    private static <E1, E2> void showArrays(E1[] a1, E2[] a2) {
        for (E1 c : a1) {
            for (E2 e : a2) {
                System.out.println(c);
                System.out.println(e);
            }
        }
    }

    /**
     * this is how we write generics methods. what we're telling java is that the
     * letter 'E' is actually a placeholder since we don't want to commit a data
     * type right away, instead we defer the selection when we go to use the method.
     * <p></p>
     * thus requiring only 1 method to achieve the same thing as when we created the
     * two methods below.
     */
    @SuppressWarnings("rawtypes")
    private static <E extends Comparable> void showArray(E[] array) {
        for (E e : array) {
            System.out.println(e + " ");
        }
        System.out.println();
    }

    private static void showIntegerArray(Integer[] array) {
        for (int i : array) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    private static void showCharacterArray(Character[] array) {
        for (char c : array) {
            System.out.println(c + " ");
        }
        System.out.println();
    }
}
