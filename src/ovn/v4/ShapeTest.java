package ovn.v4;

import static ovn.v4.ShapeType.*;

public class ShapeTest {

    public static Shape createShape(ShapeType shapeType) {
        double l = 3.0;
        double w = 2.0;
        //https://javarevisited.blogspot.com/2013/04/how-to-compare-two-enum-in-java-equals.html

        switch (shapeType) {
            case ELLIPSE:
                return new Ellipse(l, w);
            case RECTANGLE:
                return new Rectangle(l, w);
            case RESIZABLE_RECTANGLE:
                return new ResizableRectangle(l,w);
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

        Shape shape2 = createShape(RESIZABLE_RECTANGLE);
        viewShapeInfo(shape2);
        if( shape2 instanceof Resizable)
            ((Resizable) shape2).resize(200);
        viewShapeInfo(shape2);



    }
}
