package array;

import java.util.Scanner;

public class ArrayExample {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Press enter to start allocation");
//        scanner.nextLine();
//
//        //To be able to create this max array size use VM flag -Xmx10g when starting application
//        int[] big = new int[Integer.MAX_VALUE-8];
//        System.out.println("Big array allocated");
//        System.out.println("Press enter to release array");
//        scanner.nextLine();
//        //big = null;
//        //System.gc();
//        scanner.nextLine();

//        int[] array = new int[4];
//        array[0] = 10;
//        System.out.println(array[0]);
//        System.out.println(array.length);
//
        //For each loop
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        for (String car : cars) {
            System.out.print(car);
            if (car.length() < 4) {
                System.out.print("\t");
            }
            System.out.print("\t");
        }
    }

    public static void print2DimArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }

    }

    private static int findIndexOfCar(String brand, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (brand.equals(array[i]))
                return i;
        }
        return -1;
    }
}
