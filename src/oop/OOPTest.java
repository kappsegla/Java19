package oop;

import java.util.Scanner;

public class OOPTest {

    static Scanner scanner = new Scanner(System.in);
    final static int i = 0;

    public static void main(String[] args) {

        final int[] array = {1,2,3,4};

        for (int i : array ) {
            System.out.print(i);
        }
        System.out.println();

        array[0] = 5;

        for (int i : array ) {
            System.out.print(i);
        }
        System.out.println();

        Point p1 = new Point();


//        System.out.print("Number of iterations: ");
//        final int k = scanner.nextInt();
//        for (int j = 0; j < k; j++) {
//            System.out.println(j);
//        }


//        Point p1 = new Point();  //Create new point objekt with default constructor x=0.0, y=0.0
//        Point p2 = new Point(2.0, 2.0);  //Point with x = 2.0 and y = 2.0
//        Point p3 = new Point(p2);  //Create new point with same coords as p2, copy-constructor
//
//        double[] arr = {1.0, 1.0};
//        Point p4 = new Point(arr);
//
//        System.out.println(p2.distanceTo(p1));  //Calculate distance between point p2 and p1, 2.828
//        System.out.println(p2.distanceTo(p3));  //Calculate distance between point p2 and p3, 0.0
//
//
//        p3.setX(1.0);  //Change values for p3
//        p3.setY(1.0);
//        System.out.println(p2.distanceTo(p3));  //Calculate distance between point p2 and p3, 1.414
    }


    private static void showMenu() {
        System.out.println("This is a menu. Make a choice:");
        int i = readInt();
    }

    public static int readInt(){
        scanner.nextLine();
        return 0;
    }



}
