package polymorphism;

public class PolyExample {
    public static void main(String[] args) throws InterruptedException {
        Circle circle = new Circle(1.0);
        System.out.println( circle.getArea() );
        Circle circle2 = new Circle(1.0);

        Cylinder cylinder = new Cylinder(1.0,1.0);
        System.out.println( cylinder.getArea() );

        Circle circle1 = cylinder;
        System.out.println( circle1.getArea() );

        System.out.println( circle );
        System.out.println( cylinder );

        if( circle.equals(circle2) )
        {
            System.out.println("Equals");
        }



    }
}