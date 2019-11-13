package patterns.functionaldecorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Pizza basicPizza = () -> "Cheese, TomatoSauce";

//        Pizza pizzaOrder = PizzaBaker.orderPizza(basicPizza);
//        System.out.printf("Pizza: %s \nPrice => %.2fkr \n\n", pizzaOrder.getDescription(), pizzaOrder.getPrice());

        Pizza pizzaOrder = PizzaBaker.orderPizza(basicPizza, Pizza::Pineapple, Pizza::Curry);

        System.out.printf("Pizza: %s \nPrice => %.2fkr \n\n", pizzaOrder.getDescription(), pizzaOrder.getPrice());



//        Pizza pizzaOrder = PizzaBaker.orderPizza(basicPizza, ingredient -> new Pizza() {
//            @Override
//            public String getDescription() {
//                return ingredient.getDescription() + ", Pineapple";
//            }
//        });
//        System.out.printf("Pizza: %s \nPrice => %.2fkr \n\n" , pizzaOrder.getDescription() , pizzaOrder.getPrice() );
//    }
    }
}
