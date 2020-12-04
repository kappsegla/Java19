package patterns.composite.arithmetic;

import java.util.function.DoubleBinaryOperator;

public interface Arithmetic {
    DoubleBinaryOperator ADD = (left, right) -> left + right;
    DoubleBinaryOperator SUB = (left, right) -> left - right;
    DoubleBinaryOperator MUL = (left, right) -> left * right;
    DoubleBinaryOperator DIV = (left, right) -> left / right;

    double compute();
}