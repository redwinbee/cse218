package p2_things_to_know;

import java.util.StringJoiner;

public class Point<T> {
    private T x;
    private T y;

    // 2) you cannot construct objects using generics*
    // * (at least this way)
//    public Point() {
//        T t = new T();
//    }

    // 3) generic types can't be used in static contexts
//    private static T z;
    public Point(T x, T y) {
        super();
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    // 4) pretty much same as 3, you can't use T inside static methods
//    public static void display() {
//        T type;
//    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }
}
