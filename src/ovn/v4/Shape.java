package ovn.v4;

public abstract class Shape {

    private double length;
    private double width;

    public Shape(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nLength : " + length +
                "\nWidth  : " + width +
                "\nPeri   : " + getPerimeter() +
                "\nArea   : " + getArea();
    }
}
