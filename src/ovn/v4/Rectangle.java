package ovn.v4;

public class Rectangle extends Shape {
    public Rectangle(double l, double w) {
        super(l,w);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2 * getLength() + 2*getWidth();
    }
}
