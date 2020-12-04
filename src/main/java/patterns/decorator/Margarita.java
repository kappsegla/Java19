package patterns.decorator;

public class Margarita implements Pizza {
    @Override
    public String getDescription() {
        return "Margarita";
    }

    @Override
    public double getPrice() {
        return 50;
    }
}
