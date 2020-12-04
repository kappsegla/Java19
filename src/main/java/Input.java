import java.util.Scanner;

public class Input {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String textInput = input.nextLine();

        int tal = 0;
        try {
            tal = Integer.parseInt(textInput);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println(tal);
    }
}
