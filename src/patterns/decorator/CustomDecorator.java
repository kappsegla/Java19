package patterns.decorator;

public class CustomDecorator extends PizzaDecorator {

    String ingredient;
    double price;

    public CustomDecorator(Pizza pizza, String ingredient, double price) {
        super(pizza);
        this.ingredient = ingredient;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " ," + ingredient;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + price;
    }
}
