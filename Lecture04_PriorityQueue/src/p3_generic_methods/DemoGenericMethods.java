package p3_generic_methods;

public class DemoGenericMethods {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5}; // boxed as Integer objects
        Character[] array2 = {'A', 'B', 'C', 'D'}; // boxed as Character objects
        showIntegerArray(array1);
//         showIntegerArray(array2); <- only accepts Integer objects
        showCharacterArray(array2);
//        showCharacterArray(array1); <- only accepts Character objects

        /*
        when we go to use this method we ask the compiler to fill in the type at
        compile-time, meaning that it won't have any affect during run-time since
        the Erasure happens at compile-time.
         */
        showArray(array1);
        showArray(array2);
    }

    /**
     * this is how we write generics methods. what we're telling java is that the
     * letter 'E' is actually a placeholder since we don't want to commit a data
     * type right away, instead we defer the selection when we go to use the method.
     * <p></p>
     * thus requiring only 1 method to achieve the same thing as when we created the
     * two methods below.
     */
    private static <E> void showArray(E[] array) {
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
