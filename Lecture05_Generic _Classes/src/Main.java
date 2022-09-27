import p1.Point;

public class Main {
    public static void main(String[] args) {
        Point<Double, Double> p1 = new Point<>(1.0, 2.0);
        Point<Integer, Integer> p2 = new Point<>(1, 2);
        Point<Long, Long> p3 = new Point<>(1L, 2L);
        //Point<String, String> p4 = new Point<>("1", "2"); <- this won't work now since T must be a number
        Point<Long, String> p5 = new Point<>(1L, "A");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        //System.out.println(p4);
        System.out.println(p5);
    }
}