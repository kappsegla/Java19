package ovn.v2;

import java.util.Scanner;

public class UppgifterV2 {

    public static void main(String[] args) {
        //Test of isEven
        System.out.println(isEven(4));  //Should return true
        System.out.println(isEven(1));  //Should return false
        System.out.println(isEven(-3)); //Should return false
    }

    public static boolean isEven(int tal){
        return tal % 2 == 0;
    }

    public static int readInt(Scanner sc){
        return Integer.parseInt(sc.nextLine());
    }

    public static double meanValue(int a, int b){
        return (a + b)/2.0;
    }

    public static boolean isAuthorized(String passw1, String passw2, String passw3){
        String apass = "snuff";
        String bpass = "piggy";
        String cpass = "bark";

        return false;
    }
}
