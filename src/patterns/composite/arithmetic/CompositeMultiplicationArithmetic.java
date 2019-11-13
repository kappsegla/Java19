package patterns.composite.arithmetic;

public class CompositeMultiplicationArithmetic implements Arithmetic {

    Arithmetic left;
    Arithmetic right;

    public CompositeMultiplicationArithmetic(Arithmetic left, Arithmetic right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double compute() {
        return left.compute() * right.compute();
    }
}
