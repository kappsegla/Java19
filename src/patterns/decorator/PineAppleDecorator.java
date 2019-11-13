package patterns.decorator;

public class PineAppleDecorator extends PizzaDecorator {

    public PineAppleDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Pineapple";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 6;
    }
}
