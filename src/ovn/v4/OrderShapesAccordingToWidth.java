package ovn.v4;

import java.util.Comparator;

public class OrderShapesAccordingToWidth implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
       return Double.compare(o1.getWidth(),o2.getWidth());
    }
}
