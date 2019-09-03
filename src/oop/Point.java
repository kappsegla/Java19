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

    public Point(double[] values) {
        this.x = values[0];
        this.y = values[1];
    }

    //Copy constructor
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double distanceTo(Point second) {
        double a = this.x - second.x;
        double b = this.y - second.y;
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
