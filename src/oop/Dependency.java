package oop;

import java.util.Scanner;

public class Dependency {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        ThisToo thisToo = new ThisToo(scanner);
        thisToo.getInput();
        thisToo.getInput(scanner);

    }


}

