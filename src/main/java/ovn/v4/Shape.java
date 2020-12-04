package ovn.v4;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class Shape implements Comparable<Shape> {

    private double length;
    private double width;

    public Shape(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public int compareTo(@NotNull Shape o) {
        return Double.compare(this.getArea(), o.getArea());
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
                "\nArea   : " + getArea() + "\n";
    }


    //Objects that are equal (according to their equals()) must return the same hash code.
    //It's not required for different objects to return different hash codes.
    //https://www.sitepoint.com/how-to-implement-javas-hashcode-correctly/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Double.compare(shape.length, length) == 0 &&
                Double.compare(shape.width, width) == 0;
    }

    @Override
    public int hashCode() {
        //Includes type name in hashcode calculating to get different hashcodes for Ellipse and Rectangle
        return Objects.hash(this.getClass().getSimpleName(), length, width);
    }

    public static Shape createShape(ShapeType shapeType) {
    double l = 3.0;
    double w = 2.0;
    //https://javarevisited.blogspot.com/2013/04/how-to-compare-two-enum-in-java-equals.html
    //sqrt(23.0);
    //isEven(34);
    switch (shapeType) {
        case ELLIPSE:
            return new Ellipse(l, w);
        case RECTANGLE:
            return new Rectangle(l, w);
        case RESIZABLE_RECTANGLE:
            return new ResizableRectangle(l, w);
        default:
            return null; //Can not happen when using enum
    }
}
}
