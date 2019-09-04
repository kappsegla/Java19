package bank;

import javax.security.auth.login.AccountException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class MyBank {
    public static void main(String[] args) {
        new MyBank().run();
    }

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Account> accounts = new ArrayList<>();

    private void run() {

        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    depositToAccount();
                    break;
                case "3":
                    withDraw();
                    break;
                case "4":
                    showSaldo();
                    break;
                case "e":
                case "E":
                    return;
            }
        }
    }

    private void showSaldo() {
        Account account = getAccount();
        System.out.println(account.getSaldo().toString());
    }

    private void depositToAccount() {
        Account account = getAccount();
        account.deposit(getAmount());
        showSaldo();
    }

    private void withDraw() {
        Account account = getAccount();
        account.withdraw(getAmount());
        showSaldo();
    }

    private Account getAccount() {
        System.out.print("Account number: ");
        long accountId = Integer.parseInt(scanner.nextLine());
        return accounts.get((int) accountId);
    }

    private BigDecimal getAmount() {
        System.out.print("Amount: ");
        String amount = scanner.nextLine();
        //Regular expression
        if (amount.matches("^\\d*\\.\\d+|\\d+\\.\\d*$")) {
            return new BigDecimal(amount);
        }
        return BigDecimal.ZERO;
    }

    private void createAccount() {
        Account account = new Account();
        System.out.format("Account created with id: %d\n", account.getId());
        accounts.add(account);
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



