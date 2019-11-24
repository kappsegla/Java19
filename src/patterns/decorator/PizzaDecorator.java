package patterns.decorator;

public abstract class PizzaDecorator implements Pizza {
    Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String toString() {
        return getDescription();
    }
}
