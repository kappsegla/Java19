package patterns.functionaldecorator;

public interface Pizza {
    String getDescription();

    default double getPrice() {
        return 50;
    }

    static Pizza Pineapple(Pizza pizza) {
        return new Pizza() {
            @Override
            public String getDescription() {
                return pizza.getDescription() + ", Pineapple";
            }

            @Override
            public double getPrice() {
                return pizza.getPrice() + 5;
            }
        };
    }
    static Pizza Curry(Pizza pizza) {
        return new Pizza() {
            @Override
            public String getDescription() {
                return pizza.getDescription() + ", Curry";
            }

            @Override
            public double getPrice() {
                return pizza.getPrice() + 3;
            }
        };
    }
}
