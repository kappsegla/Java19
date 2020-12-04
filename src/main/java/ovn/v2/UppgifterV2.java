package ovn.v2;

import java.util.Arrays;
import java.util.Scanner;

public class UppgifterV2 {

    public static void main(String[] args) {
        //Test of isEven
//        System.out.println(isEven(4));  //Should return true
//        System.out.println(isEven(1));  //Should return false
//        System.out.println(isEven(-3)); //Should return false

        isAuthorized("bark","snuff","piggy");
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
        String apass = "bark";
        String bpass = "piggy";
        String cpass = "snuff";

        String[] solution = {apass,bpass,cpass};

        String[] passwords = {passw1,passw2,passw3};

        Arrays.sort(passwords);

       if( Arrays.compare(passwords, solution) == 0 )
           return true;

//        if( apass == passwords[0] && bpass == passwords[1] && cpass == passwords[2])
//            return true;

        return false;
    }
}
