package oop;

public class OOPTest {

    public static void main(String[] args) {

        Point p1 = new Point();
        Point p2 = new Point(2.0,2.0);
        Point p3 = new Point(p2);

        System.out.println(p2.distanceTo(p1));
        System.out.println(p2.distanceTo(p3));

        p3.setX(1.0);
        p3.setY(1.0);
        System.out.println(p2.distanceTo(p3));

    }
}
