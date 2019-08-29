package array;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample {

    public static void main(String[] args) {
//        int[] array = new int[4];
//
//        array[0] = 10;
//
//        System.out.println(array[0]);
//        System.out.println(array.length);
//
//        String s = "Hej";
//        s.length();
        //For each loop
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        Scanner scanner = new Scanner(System.in);
        String searchString = scanner.nextLine();

        int index = findIndexOfCar(searchString, cars);
        System.out.println(index);

//        for (String car : cars) {
//            System.out.print(car);
//            if( car.length() < 4) {
//                System.out.print("\t");
//            }
//            System.out.print("\t");
    }

    private static int findIndexOfCar(String brand, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if( brand.equals( array[i] ) )
                return i;
        }
        return -1;
    }
}
