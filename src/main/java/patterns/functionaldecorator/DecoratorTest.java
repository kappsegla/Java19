package patterns.functionaldecorator;

public class DecoratorTest {

    //Functional style implementation of Decorator pattern
    //https://israeldago.com/decorator-pattern-applied-with-functional-style/


    public static void main(String[] args) {
        Pizza basicPizza = () -> "Cheese, TomatoSauce";

        //Order a basicPizza with nothing extra
//        Pizza pizzaOrder = PizzaBaker.orderPizza(basicPizza);
//        System.out.printf("Pizza: %s \nPrice => %.2fkr \n\n", pizzaOrder.getDescription(), pizzaOrder.getPrice());

        //Order a basicPizza but with extra Pineapple and Curry
//        Pizza pizzaOrder = PizzaBaker.orderPizza( basicPizza, Pizza::withPineapple, Pizza::withCurry);
//        System.out.printf("Pizza: %s \nPrice => %.2fkr \n\n", pizzaOrder.getDescription(), pizzaOrder.getPrice());

        //Order a customPizza with extra Curry
        Pizza pizzaOrder = PizzaBaker.orderPizza( ()-> "4 Cheeses", Pizza::withCurry);
        System.out.printf("Pizza: %s\nPrice => %.2fkr\n\n", pizzaOrder.getDescription(), pizzaOrder.getPrice());
    }
}
