package p1;

import java.util.StringJoiner;

@SuppressWarnings("unused")
public class Point<T extends Number, S> {
    private T x;
    private S y;

    public Point(T x, S y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public S getY() {
        return y;
    }

    public void setY(S y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }
}
