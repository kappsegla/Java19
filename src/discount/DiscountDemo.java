package discount;

import java.util.ArrayList;
import java.util.List;

public class DiscountDemo {

    List<Product> products = new ArrayList<>();
    List<Discount> discountRules = new ArrayList<>();

    public static void main(String[] args) {
        DiscountDemo discountDemo = new DiscountDemo();
        discountDemo.run();
    }

    private void run() {
        discountRules.add( new TuesdayDiscount());
   //     discountRules.add(this::calculatePrice);
//        discountRules.add( p -> {
//            int count =(int) p.stream().filter(product -> product.getName().equals("Apple")).count();
//            if( count > 1)
//                return 5.0;
//            return 0.0;
//        });

        products.add(Product.of("Cola", 10.0));
        products.add(Product.of("Apple", 5.0));
        products.add(Product.of("Apple", 5.0));
        products.add(Product.of("Banana", 15.0));

        double sum = calculatePrice(products);

        var discountedSum = discountRules.stream().mapToDouble(discount -> discount.calcDiscount(products)).sum();

        System.out.println(products);
        System.out.println(sum);
        System.out.println(discountedSum);
    }

    public double calculatePrice(List<Product> productList) {
        return productList.stream().mapToDouble(product -> product.getPrice().doubleValue()).sum();
    }
}
