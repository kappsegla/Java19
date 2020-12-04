package patterns.composite.arithmetic;

import java.util.function.DoubleBinaryOperator;

public class ArithmeticOperation implements Arithmetic{

    double tal1;
    double tal2;
    DoubleBinaryOperator operator;

    public ArithmeticOperation(double tal1, double tal2, DoubleBinaryOperator operator) {
        this.tal1 = tal1;
        this.tal2 = tal2;
        this.operator = operator;
    }

    @Override
    public double compute() {
        return operator.applyAsDouble(tal1,tal2);
    }
}
