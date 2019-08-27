package ovn;

import java.util.Scanner;

public class Uppg20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double tal1 = Float.parseFloat(input);

        input = scanner.nextLine();
        double tal2 = Float.parseFloat(input);

        double diff = Math.abs(tal1 - tal2);
        System.out.println(diff);

        if (diff < 0.001) {
            System.out.println("Talen är lika till 3 decimaler");
        } else {
            System.out.println("Talen är olika till 3 decimaler");
        }



    }
}
