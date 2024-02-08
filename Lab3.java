// Programmers:  [your names here]
// Course:  CS 212
// Due Date:
// Lab Assignment:
// Problem Statement:
// Data In:
// Data Out:
// Credits: [Is your code based on an example in the book, in class, or something else?
//            Reminder: you should never take code from the Internet or another person

import java.util.Scanner;
import java.text.NumberFormat;

class Lab3 {

// METHODS 
    // Deposit
    public static double deposit(double currentBalance, double depositValue){
        currentBalance = currentBalance + depositValue;
        return currentBalance;
    }

    // Widthdraw
    public static double widthdraw(double currentBalance, double widthdrawValue){
        currentBalance = currentBalance - widthdrawValue;
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
        NumberFormat myformat = NumberFormat.getInstance();

        System.out.println("Welcome to Lab 3");

        double currentBalance = 212.90;
        boolean finished = false;


        System.out.println("What is your name?: ");
        String userName = scanner.next();


        while (!finished){
            System.out.println("Welcome, " + userName + " what would you like to do today?");
            System.out.println("Deposit (d), widthdraw (w), check balance (c), or leave (l)?: ");
            String selection = scanner.next();
            selection.toLowerCase();

            if (selection.equals("d")) {
                System.out.println("\nEnter deposit amount: ");
                double depositValue = scanner.nextDouble();
                currentBalance = deposit(currentBalance, depositValue);
                System.out.println("\nYour new balance is: " + "$"+myformat.format(currentBalance));
            }

            else if (selection.equals("w")) {
                System.out.println("\nEnter widthdraw amount: ");
                double widthdrawValue = scanner.nextDouble();
                currentBalance = widthdraw(currentBalance, widthdrawValue);
                System.out.println("\nYour new balance is: " + "$"+myformat.format(currentBalance));
            }

            else if (selection.equals("c")) {
                System.out.println("\nYour current balance is: " + "$"+myformat.format(currentBalance));
            }

            else if (selection.equals("l")){
                System.out.println("\nThank you for using our ATM. Have a great day " + userName + ".");
                finished = leave();
            }

            else{
                System.out.println("Please enter a valid option.\n");
            }
        }   

        scanner.close();
    }
}
