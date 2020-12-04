package patterns.decorator;

public class Vesuvio implements Pizza {
    @Override
    public String getDescription() {
        return "Vesuvio";
    }

    @Override
    public double getPrice() {
        return 60;
    }
}
