package discount;

import java.util.List;

@FunctionalInterface
public interface Discount {
    double calcDiscount(List<Product> productList);
}
