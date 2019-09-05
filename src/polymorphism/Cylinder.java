package polymorphism;

public class Cylinder extends Circle {

    private double height;

    public Cylinder() {

    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return super.getArea() * 2.0 + super.getCircumference() * height;
    }

    @Override
    public String toString() {
        return "Cylinder, radius= " + getRadius() + ", height= " +height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Cylinder guest = (Cylinder) obj;
        return getRadius() == guest.getRadius() &&
                    height == guest.height;
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(getRadius(),height);
    }
}
