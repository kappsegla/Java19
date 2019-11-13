package patterns.composite.arithmetic;

public class SubtractionArithmetic implements Arithmetic {
    double tal1;
    double tal2;

    public SubtractionArithmetic(double tal1, double tal2) {
        this.tal1 = tal1;
        this.tal2 = tal2;
    }

    @Override
    public double compute() {
        return tal1 - tal2;
    }
}
