package polymorphism;

import java.util.HashMap;

public class PolyExample {
    public static void main(String[] args) throws InterruptedException {
        Circle circle = new Circle(1.0);
        System.out.println( circle.getArea() );
        Circle circle2 = new Circle(1.0);

        circle.printSomething();

        Cylinder cylinder = new Cylinder(1.0,1.0);
        System.out.println( cylinder.getArea() );

        cylinder.printSomething();

        Circle circle1 = cylinder;
        System.out.println( circle1.getArea() );
        circle1.printSomething();

        System.out.println( circle );
        System.out.println( cylinder );

        if( circle.equals(circle2) )
        {
            System.out.println("Equals");
        }



    }
}