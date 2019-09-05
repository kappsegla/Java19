package polymorphism;

public class Circle {

    //Fields
    private double radius;

    //Default Constructor
    public Circle() {

    }

    /**
     * Constructor for Circle class
     * @param radius Radius of circle as a decimal number. Avoid negative numbers.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    //<editor-fold desc="Getters/Setters">
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //</editor-fold>

    //Convenience methods written as getters but without backing fields.
    public double getCircumference() {
        return radius * 2.0 * Math.PI;
    }

    public double getArea() {
        //return Math.pow(radius, 2) * Math.PI;
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle, radius= " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Circle guest = (Circle) obj;
        return radius == guest.radius;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(radius);
    }
}
