package ovn.v4;

public class ResizableRectangle extends Rectangle implements Resizable {
    public ResizableRectangle(double l, double w) {
        super(l, w);
    }

    @Override
    public void resize(int percent) {
        double p = percent / 100.0;
        setLength(getLength() * p);
        setWidth(getWidth() * p);
    }
}
