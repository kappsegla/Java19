package oop;

public class Point {

    private double x;
    private double y;

    public Point() {
        x = 0.0;
        y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Copy constructor
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double distanceTo(Point other) {
        double a = this.x - other.x;
        double b = this.y - other.y;
        return Math.sqrt(a * a + b * b);
    }

    //<editor-fold desc="Getters/Setters">
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    //</editor-fold>
}
