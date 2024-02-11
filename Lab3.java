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
        boolean finished = false;
        return finished;

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
        boolean finished = false;


        System.out.println("What is your name?: ");
        String userName = scanner.next();
        System.out.println();


        while (!finished){
            System.out.println("Welcome, " + userName + ". What would you like to do today?");
            System.out.println("Deposit (d), withdraw (w), check balance (c), or leave (l)?: ");
            String selection = scanner.next();
            selection.toLowerCase();

            if (selection.equals("d")) {
                System.out.println("\nEnter deposit amount: ");
                double depositValue = scanner.nextDouble();
                currentBalance = deposit(currentBalance, depositValue);
                System.out.println("\nYour new balance is: " + currency.format(currentBalance));
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
                //System.out.println();

            }

            else if (selection.equals("w")) {
                System.out.println("\nEnter withdraw amount: ");
                double withdrawValue = scanner.nextDouble();
                currentBalance = withdraw(currentBalance, withdrawValue);
                System.out.println("\nYour new balance is: " + currency.format(currentBalance));
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();

            }

            else if (selection.equals("c")) {
                System.out.println("\nYour current balance is: " + currency.format(currentBalance));
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();

            }

            else if (selection.equals("l")){
                System.out.println("\nThank you for using our ATM. Have a great day, " + userName + ".");
                finished = leave();
                break;
            }

            else{
                System.out.println("Please enter a valid option.\n");
            }
        }

        scanner.close();
    }
}