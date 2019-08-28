public class Circle {

    //Fields
    private double radius;
    private boolean filled;

    //Constructor
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

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    //</editor-fold>

    public double getCircumference(){
        return radius * 2.0 * Math.PI;
    }

    public double getArea() {
        //return Math.pow(radius, 2) * Math.PI;
        return radius * radius * Math.PI;
    }
}
