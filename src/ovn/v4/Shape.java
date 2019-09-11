package ovn.v4;

import java.util.Objects;

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
        return Objects.hash(this.getClass().getSimpleName(),length, width);
    }
}
