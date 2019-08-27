package methods;

import java.util.Scanner;

public class MethodsExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //int x = 2;
        //printMultiplicationTable(x);
        //double sum = add(1,2);

        double tax = calculateTax(230000);
        System.out.println(tax);

        String input = scanner.nextLine();

        int income = Integer.parseInt(input);
        System.out.println(calculateTax(income));

    }

    public static double calculateTax(int income) {
        if (income > 100000) {
            return income * 0.4;
        } else {
            return income * 0.3;
        }
    }


    public static void printMultiplicationTable(int tableNumber) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i * tableNumber);
        }
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int add(int x, int y, int z) {
        return x + y + z;
    }

    public static double add(double x, double y) {
        return x + y;
    }


}
