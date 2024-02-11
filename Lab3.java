// Programmers: Ricky Johnson, Clayton Powell
// Course: CS 212
// Due Date: 2/11/24
// Lab Assignment: 3
// Problem Statement: Develop a program that acts at a smart ATM
// Data In: name
// Data Out:
// Credits: [Is your code based on an example in the book, in class, or something else?
//            Reminder: you should never take code from the Internet or another person

import java.text.DecimalFormat;
import java.util.Scanner;
import java.text.NumberFormat;

class Lab3 {

    // METHODS
    // Deposit
    public static double deposit(double currentBalance, double depositValue){
        currentBalance = currentBalance + depositValue;
        return currentBalance;
    }

    // withdraw
    public static double withdraw(double currentBalance, double withdrawValue){
        currentBalance = currentBalance - withdrawValue;
        return currentBalance;

    }

    // Leave
    public static boolean leave(){
        boolean proceed = false;
        return proceed;

    }

    // Error Checks
    // Negative Number (Deposit)
    public static double negativeNumber(double value){
        while (value <= 0){
            System.out.println("You must deposit at least $0.01");
            System.out.println("Enter deposit amount: ");

        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat currency = new DecimalFormat("$#,##0.00");

        System.out.println();
        System.out.println("Lab 3");
        System.out.println("Welcome to the ATM.");
        System.out.println();

        double currentBalance = 212.90;
        boolean proceed = true;


        System.out.println("What is your name?: ");
        String userName = scanner.next();

        System.out.println();
        System.out.println("Welcome, " + userName + ". What would you like to do today?");

        while (proceed){
            System.out.println();
            System.out.println("Deposit (d), withdraw (w), check balance (c), or leave (l)?: ");
            String selection = scanner.next();
            String selectionLower = selection.toLowerCase();

            if (selectionLower.equals("d")) {
                System.out.println("\nEnter deposit amount: ");
                double depositValue = scanner.nextDouble();

                // Error Check for negative deposit
                while (depositValue <= 0){
                    System.out.println("You must deposit at least $0.01");
                    System.out.println("Enter deposit amount: ");
                    depositValue = scanner.nextDouble();

                // Deposit Calculation
                currentBalance = deposit(currentBalance, depositValue);

                // Print current balance after deposit
                System.out.println("\nYour new balance is: " + currency.format(currentBalance));
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
            }

            else if (selectionLower.equals("w")) {
                System.out.println("\nEnter withdraw amount: ");
                double withdrawValue = scanner.nextDouble();
                currentBalance = withdraw(currentBalance, withdrawValue);
                System.out.println("\nYour new balance is: " + currency.format(currentBalance));
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
            }

            else if (selectionLower.equals("c")) {
                System.out.println("\nYour current balance is: " + currency.format(currentBalance));
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
            }

            else if (selectionLower.equals("l")){
                // The ATM should ask if the user would like a receipt printed or emailed.
                System.out.println("\nWould you like your receipt printed (p) or emailed (e)?");
                String receipt = scanner.next();
                String receiptLower = receipt.toLowerCase();
                System.out.println();

                // The ATM should remind them to take the recipe or check their email depending on the option above.
                while (!receiptLower.equals("p") && (!receiptLower.equals("e"))){
                    System.out.println("Invalid selection. Select p or e.");
                    receipt = scanner.next();
                    receiptLower = receipt.toLowerCase();
                    System.out.println();
                }
                if (receiptLower.equals("p")) {
                    System.out.println("Remember to take your receipt.");
                }
                else if (receiptLower.equals("e")) {
                    System.out.println("Your receipt will be emailed to the email address associated with your account.");
                }

                // The ATM should display the total amount deposited/withdrawn and a thank you message.
                System.out.println("Thank you for using our ATM. Have a great day, " + userName + ".");

                proceed = leave();

            }

            else{
                System.out.println("Please enter a valid option (d, w, c, or l).\n");
            }
        }

        scanner.close();
    }
}