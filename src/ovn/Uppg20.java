package ovn;

import java.util.Scanner;

public class Uppg20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double tal1 = Float.parseFloat(input);
        //tal1 = tal1 - (int)tal1;
        input = scanner.nextLine();
        double tal2 = Float.parseFloat(input);
        //tal2 = tal2 - (int)tal2;

        double diff = Math.abs(tal1 - tal2);
       // System.out.println(diff);

//        if (diff < 0.001) {
//            System.out.println("Talen är lika till 3 decimaler");
//        } else {
//            System.out.println("Talen är olika till 3 decimaler");
//        }

        int heltal1 = (int)(tal1 * 1000);

        int heltal2 = (int) (tal2 * 1000);

        System.out.println(heltal2);
        if( heltal1 == heltal2)
        {
            System.out.println("lika");
        }
        else
        {
            System.out.println("olika");
        }
    }
}
