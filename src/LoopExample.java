import java.util.Scanner;

public class LoopExample {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

//        //for loop that runs 3 times
//        for (int i = 0; i < 3; i++) {
//            String textInput = input.nextLine();
//            System.out.println(i + ": " + textInput);
//        }

//        //for loop that runs 4 times
//        for (int i = 0; i <= 3 ; ) {
//            String textInput = input.nextLine();
//            System.out.println(i + ": " + textInput);
//            i++;
//        }
//
//        //Same functionality as for loop examples above. Runs 3 times.
//        int i = 0;
//        while (i < 3) {
//            String textInput = input.nextLine();
//            System.out.println(i + ": " + textInput);
//            i++;
//        }

          //Infinite looping with break condition
        byte b = 125;

        while( true )
        {
            System.out.println(b++);
            if( b == 0 ) {
                System.out.println("Exiting");
                break;
            }
        }

        //Inifinite loop, for style.
//        for(;;){
//            System.out.println("Never stops...");
//        }

//        while(true){
//            int i = 0;
//            while(i < 5){
//                System.out.println(i++);
//            }
//        }

        //loop in loop that prints multiplication table
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println("");
        }





    }
}
