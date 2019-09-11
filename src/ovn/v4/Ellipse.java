package ovn.v4;

public class Ellipse extends Shape {
    public Ellipse(double l, double w) {
        super(l, w);
    }

    @Override
    public double getArea() {
        return Math.PI * (getLength() / 2.0) * (getWidth() / 2.0);
    }

    @Override
    public double getPerimeter() {
        //https://www.mathsisfun.com/geometry/ellipse-perimeter.html
        double a = getWidth()/2.0;
        double b = getLength()/2.0;
        return Math.PI * ( 3*(a+b) - Math.sqrt((3*a + b) * (a + 3*b)) );
    }
}
