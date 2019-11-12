package ovn.v4;

import javax.swing.border.Border;
import java.util.Arrays;
import java.util.Comparator;

import static ovn.v4.ShapeType.*;
import static java.lang.Math.*;
import static ovn.v2.UppgifterV2.*;
public class ShapeTest {

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
        shapes[0] = Shape.createShape(RECTANGLE);
        shapes[1] = Shape.createShape(RECTANGLE);
        shapes[2] = Shape.createShape(ELLIPSE);
        shapes[3] = Shape.createShape(ELLIPSE);
        shapes[1].setLength(1.0);
        shapes[0].setWidth(10.0);

        System.out.println(Arrays.toString(shapes));
        Arrays.sort(shapes);  //Natural order for the sorting, default implementation in compareTo for Object
        System.out.println(Arrays.toString(shapes));

//        Arrays.sort(shapes, new Comparator<Shape>() {
//            @Override
//            public int compare(Shape o1, Shape o2) {
//                return 0;
//            }
//        });
    }
}
