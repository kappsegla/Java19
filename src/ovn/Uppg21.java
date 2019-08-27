package ovn;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class Uppg21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.length() > 1) {
            System.out.println("Too many zoos");
        } else if (input.length() == 0) {
            System.out.println("You have to write something");
        } else {

            char tecken = input.toLowerCase().charAt(0);

            //System.out.println((int)tecken);
            //System.out.println(tecken);

            if (tecken >= 'a' && tecken <= 'z') {// || tecken >= 'A' && tecken <= 'Z'){




            }
        }


    }


}
