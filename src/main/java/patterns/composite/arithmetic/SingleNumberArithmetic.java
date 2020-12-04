package patterns.composite.arithmetic;

public class SingleNumberArithmetic implements Arithmetic {
    double tal;

    public SingleNumberArithmetic(double tal) {
        this.tal = tal;
    }

    @Override
    public double compute() {
        return tal;
    }
}
