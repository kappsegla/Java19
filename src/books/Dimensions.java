package books;

//Immutable implementation of Dimensions. No Setters.
//Makes it possible to share Dimensions objects between Books

import java.util.Objects;

public class Dimensions {
    private int width;
    private int height;
    private int depth;
    private int weight;

    public final static Dimensions ZERO = new Dimensions(0,0,0,0);

    public Dimensions(int width, int height, int depth, int weight) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.weight = weight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public int getWeight() {
        return weight;
    }

    public static Dimensions zero() {
        return new Dimensions(0,0,0,0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimensions that = (Dimensions) o;
        return width == that.width &&
                height == that.height &&
                depth == that.depth &&
                weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, depth, weight);
    }

    @Override
    public String toString() {
        return "Dimensions{" +
                width + " x " +
                height + " x " +
                depth + " mm\n" +
                ", weight=" + weight +
                '}';
    }
}
