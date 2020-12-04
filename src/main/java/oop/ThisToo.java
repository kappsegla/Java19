package oop;

import java.util.Scanner;

public class ThisToo {

    private Scanner scanner;

    //Dependency Injection of Scanner thru constructor
    public ThisToo(Scanner scanner) {
        this.scanner = scanner;
    }

    //Dependency Injection thru setter
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    //Don't do like this!!!!
//    public void getInput() {
//        String s = Dependency.scanner.nextLine();
//
//    }

    public void getInput() {
        String s = scanner.nextLine();
    }

    //Dependency Injection as argument to method
    public void getInput(Scanner scanner) {
        String s = scanner.nextLine();
    }

}
