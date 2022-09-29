package p1_constraints;

public class DemoPoint {
    public static void main(String[] args) {
        Point<Integer> p1 = new Point<>(1, 2);
        Point<String> p2 = new Point<>("One", "Two");
        Point<Object> p3 = new Point<>(1, 1.5);

        //display1(p3);
        display2(p3);
    }

    /**
     * this method can display points so long as the point provided is
     * any class that extends Number. This is known as:
     * <p></p>
     * Wildcard upper-bound constraint
     */
    private static void display1(Point<? extends Number> point) {
        System.out.println(point);
    }

    /**
     * this method can display points that are either Number type or anything
     * that is a super type of Number. For example this can display Object since Object
     * is a super class of Number.
     * <p></p>
     * Wildcard lower-bound constraint
     */
    private static void display2(Point<? super Number> point) {
        System.out.println(point);
    }
}
