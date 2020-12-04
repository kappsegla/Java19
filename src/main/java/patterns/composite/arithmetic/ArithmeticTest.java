package patterns.composite.arithmetic;

import static patterns.composite.arithmetic.ArithmeticOperation.*;

public class ArithmeticTest {
    public static void main(String[] args) {
        Arithmetic a = new ArithmeticOperation(2,3, ADD);
        Arithmetic b = new ArithmeticOperation(4,2, Math::pow);
        //Arithmetic b = new ArithmeticOperation(4,2, MUL);
        //Arithmetic b = new SingleNumberArithmetic(4);
        Arithmetic c = new CompositeMultiplicationArithmetic(a,b);

        System.out.println(c.compute());



    }

}
