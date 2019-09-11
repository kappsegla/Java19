package ovn.v4;

import static ovn.v4.ShapeType.ELLIPSE;
import static ovn.v4.ShapeType.RECTANGLE;

public class ShapeTest {

    public static Shape createShape(ShapeType shapeType) {
        double l = 3.0;
        double w = 2.0;

        switch (shapeType) {
            case ELLIPSE:
                return new Ellipse(l, w);
            case RECTANGLE:
                return new Rectangle(l, w);
            default:
                return null; //Can not happen when using enum
        }
    }

    public static void viewShapeInfo(Shape shape) {
        System.out.println(shape);
    }

    public static void main(String[] args) {
        Shape shape = createShape(RECTANGLE);
        viewShapeInfo(shape);

        Shape shape1 = createShape(ELLIPSE);
        viewShapeInfo(shape1);

    }
}
