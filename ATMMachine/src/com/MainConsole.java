package com;

import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) {
        OperationInterface op = new OperationImplement();
        int ATMNumber = 12345;
        int ATMPin = 123;
        Scanner object = new Scanner(System.in);
        boolean authenticated = false;

        System.out.println("Welcome to the ATM Machine!");

        while (!authenticated) {
            System.out.println("Please enter the ATM Number:");
            int AttemptNumber = object.nextInt();
            System.out.println("Please enter the ATM Pin:");
            int AttemptPin = object.nextInt();

            if ((ATMNumber == AttemptNumber) && (ATMPin == AttemptPin)) {
                authenticated = true;
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Invalid account. Please try again!");
            }
        }
        
        while (true) {
            System.out.println("Choose option:");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Deposit Amount");
            System.out.println("4. View Mini Statement");
            System.out.println("5. Exit");

            int option = object.nextInt();

            if (option == 1) {
                System.out.println("Balance: ");
                op.viewBalance();
            } else if (option == 2) {
                System.out.println("Enter amount you want to withdraw: ");
                int withdraw = object.nextInt();
                op.withdrawAmount(withdraw);
            } else if (option == 3) {
                System.out.println("Enter amount you want to deposit: ");
                int deposit = object.nextInt();
                op.depositAmount(deposit);
            } else if (option == 4) {
                System.out.println("Balance fluctuation statistics: ");
                op.ViewMiniStatement();
            } else if (option == 5) {
                System.out.println("Collect your ID card!\nThanks for using our service!");
                break;
            } else {
                System.out.println("Invalid option! Please try again.");
            }
        }

        object.close();
    }
}
