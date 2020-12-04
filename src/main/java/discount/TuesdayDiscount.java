package discount;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class TuesdayDiscount implements Discount {
    int calledCount = 0;

    @Override
    public double calcDiscount(List<Product> productList) {
        if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.TUESDAY))
            return productList.stream().mapToDouble(product -> product.getPrice().doubleValue()).sum() * 0.1;
        return 0.0;
    }
}
