import java.util.Scanner;

public class LoopExample {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //for loop that runs 3 times
        for (int i = 0; i < 3; i++) {
            String textInput = input.nextLine();
            System.out.println(i + ": " + textInput);
        }

        //for loop that runs 3 times
        for (int i = 0; i < 3; ) {
            String textInput = input.nextLine();
            System.out.println(i + ": " + textInput);
            i++;
        }


        int i = 0;
        while( i < 3 ){
            String textInput = input.nextLine();
            System.out.println(i + ": " + textInput);
            i++;
        }


    }
}
