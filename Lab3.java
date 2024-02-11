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

class Lab3 {

// METHODS 
    // Deposite
    public double deposit(double currentBalance, double depositValue){
        currentBalance = currentBalance + depositValue;
        return currentBalance;
    }

    // Widthdraw
    public double widthdraw(double currentBalance, double widthdrawValue){
        currentBalance = currentBalance - widthdrawValue;
        return currentBalance;
        
    }

    // Leave
    public boolean leave(){
        boolean finished = false;
        return finished;
        
    }


    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Lab 3");

        double currentBalance = 212.90;
        boolean finished = true;


        System.out.println("What is your name?: ");
        String userName = scanner.next();

        System.out.println("Welcome, " + userName + " what would you like to do today?");
        System.out.println("Deposite, widthdraw, check balance, or leave?: ");
        String selection = scanner.next();

        if (selection == "withdraw") {
            System.out.println("Enter deposite amount: ");
            double depositValue = scanner.nextDouble();
            depositValue.deposit(depositValue);
        }
        


        System.out.println("Enter widthdraw amount: ");
        double widthdrawValue = scanner.nextDouble();

        scanner.close();
    }
}
//fdgegf
