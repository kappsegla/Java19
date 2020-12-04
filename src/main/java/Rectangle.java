public class Rectangle {

    private int width;
    private int height;
    private String name;

    public Rectangle() {
        name = "";
    }

    public Rectangle(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public void setHeight(int height) {
        if (height > 0)
            this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width > 0)
            this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
