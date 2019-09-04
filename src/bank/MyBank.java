package bank;

import javax.security.auth.login.AccountException;
import java.math.BigDecimal;
import java.util.Scanner;

public class MyBank {
    public static void main(String[] args) {
        new MyBank().run();
    }

    private Scanner scanner = new Scanner(System.in);

    private void run() {

        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createAccount();
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

    private void createAccount() {
        Account account = new Account();
        System.out.println(account.getSaldo().toString());
        String depositAmount = scanner.nextLine();
        //Regular expression
        if ( depositAmount.matches("^\\d*\\.\\d+ | \\d+\\.\\d*$") ) {
            BigDecimal amount = new BigDecimal(depositAmount);
            account.deposit(amount);
        }
        System.out.println(account.getSaldo().toString());
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



