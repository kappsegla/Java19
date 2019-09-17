package ovn.v4;

import javax.swing.border.Border;
import java.util.Arrays;
import java.util.Comparator;

import static ovn.v4.ShapeType.*;
import static java.lang.Math.*;
import static ovn.v2.UppgifterV2.*;
public class ShapeTest {

    public static Shape createShape(ShapeType shapeType) {
        double l = 3.0;
        double w = 2.0;
        //https://javarevisited.blogspot.com/2013/04/how-to-compare-two-enum-in-java-equals.html
        sqrt(23.0);
        isEven(34);
        switch (shapeType) {
            case ELLIPSE:
                return new Ellipse(l, w);
            case RECTANGLE:
                return new Rectangle(l, w);
            case RESIZABLE_RECTANGLE:
                return new ResizableRectangle(l, w);
            default:
                return null; //Can not happen when using enum
        }
    }

    public static void viewShapeInfo(Shape shape) {
        System.out.println(shape);
    }

    public static void main(String[] args) {
//        Shape shape = createShape(RECTANGLE);
//        viewShapeInfo(shape);
//
//        Shape shape1 = createShape(ELLIPSE);
//        viewShapeInfo(shape1);
//
//        Shape shape2 = createShape(RESIZABLE_RECTANGLE);
//        viewShapeInfo(shape2);
//        if( shape2 instanceof Resizable)
//            ((Resizable) shape2).resize(200);
//        viewShapeInfo(shape2);
        Shape[] shapes = new Shape[4];
        shapes[0] = createShape(RECTANGLE);
        shapes[1] = createShape(RECTANGLE);
        shapes[2] = createShape(ELLIPSE);
        shapes[3] = createShape(ELLIPSE);
        shapes[1].setLength(1.0);
        shapes[0].setWidth(10.0);

        System.out.println(Arrays.toString(shapes));
        Arrays.sort(shapes);  //Natural order for the sorting, default implementation in compareTo for Object
        System.out.println(Arrays.toString(shapes));
        Comparator<Shape> order = new OrderShapesAccordingToWidth();
        Arrays.sort(shapes, order );
        System.out.println(Arrays.toString(shapes));
        Arrays.sort(shapes, order.reversed());
        System.out.println(Arrays.toString(shapes));
//        Arrays.sort(shapes, new Comparator<Shape>() {
//            @Override
//            public int compare(Shape o1, Shape o2) {
//                return 0;
//            }
//        });
    }
}
