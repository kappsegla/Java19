package patterns.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Pizza pizza = new CustomDecorator(new PineAppleDecorator(new GarlicSauceDecorator(new Vesuvio())),"Curry", 3);
        System.out.println("Pizza: " + pizza.getDescription() + ", Price: " + pizza.getPrice());
    }
}
