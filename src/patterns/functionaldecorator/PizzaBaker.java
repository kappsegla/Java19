package patterns.functionaldecorator;

import java.util.function.Function;

public class PizzaBaker {

    private Function<Pizza, Pizza> ingredient = input -> input;

    private PizzaBaker(Function<Pizza, Pizza>... ingredients) {
        for (var aIngredient : ingredients ) {
            ingredient = ingredient.andThen(aIngredient);
        }
    }

    public static Pizza orderPizza(Pizza pizza){
        return new PizzaBaker(input->input).ingredient.apply(pizza);
    }

    public static Pizza orderPizza(Pizza pizza, Function<Pizza,Pizza>... ingredients){
        return new PizzaBaker(ingredients).ingredient.apply(pizza);
    }
}
