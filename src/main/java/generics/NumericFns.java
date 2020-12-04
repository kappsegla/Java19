package generics;

public class NumericFns<T extends Number> {

        T tal;

        public double sum(T o){
            return tal.doubleValue() + o.doubleValue();
        }

        

}
