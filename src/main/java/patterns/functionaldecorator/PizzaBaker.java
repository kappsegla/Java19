package patterns.functionaldecorator;

import java.util.function.Function;
import java.util.stream.Stream;

public class PizzaBaker {

    private Function<Pizza, Pizza> ingredient = input -> input;

    private PizzaBaker(Function<Pizza, Pizza>... ingredients) {
        this.ingredient = Stream.of(ingredients).reduce(Function.identity() , Function::andThen);
//        for (var aIngredient : ingredients ) {
//            ingredient = ingredient.andThen(aIngredient);
//        }
    }

    public static Pizza orderPizza(Pizza pizza){
        return new PizzaBaker(Function.identity()).ingredient.apply(pizza);
    }

    public static Pizza orderPizza(Pizza pizza, Function<Pizza,Pizza>... ingredients){
        return new PizzaBaker(ingredients).ingredient.apply(pizza);
    }
}
