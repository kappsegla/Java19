package books;

//Immutable implementation of Dimensions. No Setters.
//Makes it possible to share Dimensions objects between Books

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
}
