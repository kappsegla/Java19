package patterns.composite.arithmetic;

public class ArithmeticTest {
    public static void main(String[] args) {
        Arithmetic a = new ArithmeticOperation(2,3, Double::sum);
        //Arithmetic b = new ArithmeticOperation(4,2, (left, right) -> left - right);
        Arithmetic b = new ArithmeticOperation(4,2, (left, right) -> left * right);
        //Arithmetic b = new SingleNumberArithmetic(4);
        Arithmetic c = new CompositeMultiplicationArithmetic(a,b);

        System.out.println(c.compute());



    }

}
