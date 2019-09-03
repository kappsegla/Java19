package bank;

import java.util.Scanner;

public class MyBank {
    public static void main(String[] args) {
        new MyBank().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "e":
                case "E":
                    return;
            }
        }
    }

    private void printMenu() {
        System.out.println("    Welcome to MyBank");
        System.out.println("--------------------------");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit into account");
        System.out.println("3. Withdraw from account");
        System.out.println("4. Print saldo for account");
        System.out.println("e. Exit");
    }
}



