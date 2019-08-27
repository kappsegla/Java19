package methods;

public class MethodsExample {
    public static void main(String[] args) {
        //int x = 2;
        //printMultiplicationTable(x);
        double sum = add(1,2);
        System.out.println(sum);
    }

    public static void printMultiplicationTable(int tableNumber) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i * tableNumber);
        }
    }

    public static int add(int x, int y){
        return x + y;
    }

    public static int add(int x, int y, int z){
        return x + y + z;
    }

    public static double add(double x, double y){
        return x + y;
    }



}
