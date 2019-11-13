package patterns.functionaldecorator;

public class GarlicSauceDecorator extends PizzaDecorator {

    public GarlicSauceDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with GarlicSauce";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 10;
    }
}
