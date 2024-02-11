// Programmers: Ricky Johnson, Clayton Powell
// Course: CS 212
// Due Date: 2/11/24
// Lab Assignment: 3
// Problem Statement: Develop a program that acts at a smart ATM
// Data In: name
// Data Out:
// Credits: [Is your code based on an example in the book, in class, or something else?
//            Reminder: you should never take code from the Internet or another person


// Imports
import java.text.DecimalFormat;
import java.util.Scanner;

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


    // Main method
    public static void main(String[] args) {
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Create DecimalFormat object
        DecimalFormat currency = new DecimalFormat("$#,##0.00");


        // Introduce Program
        System.out.println();
        System.out.println("Lab 3");
        System.out.println("Welcome to the ATM.");
        System.out.println();


        // Assign value for user's current balance
        double currentBalance = 212.90;

        // Assign value for proceed (used for while loop to control ATM menu)
        boolean proceed = true;

        // Assign value for total amount deposited (printed when user selects "leave")
        double totalDeposit = 0;

        // Assign value for total amount withdrawn (printed when user selects "leave")
        double totalWithdraw = 0;

        // Ask user for their name
        System.out.println("What is your name?: ");
        String userName = scanner.next();

        // Welcome user to the ATM
        System.out.println();
        System.out.println("Welcome, " + userName + ". What would you like to do today?");


        // ATM Menu (controlled by while loop)
        while (proceed){    // While the user wants to proceed

            // Ask user to Deposit, Withdraw, Check Balance, or Leave
            System.out.println("Deposit (d), Withdraw (w), Check Balance (c), or Leave (l)?: ");
            String selection = scanner.next();

            // Modify selection input to be lower case
            String selectionLower = selection.toLowerCase();


            // Deposit
            if (selectionLower.equals("d")) {
                System.out.println("\nEnter deposit amount: ");
                double depositValue = scanner.nextDouble();

                // Error Check for negative deposit
                while (depositValue <= 0) {
                    System.out.println("\nYou must deposit at least $0.01");
                    System.out.println("Enter deposit amount: ");
                    depositValue = scanner.nextDouble();
                }

                // Deposit Calculation
                currentBalance = deposit(currentBalance, depositValue);

                // Update total amount deposited
                totalDeposit += depositValue;

                // Print updated balance after deposit with currency formatting
                System.out.println("\nYour new balance is: " + currency.format(currentBalance));
                System.out.println("---------------------------------------------------------------------------------");
            }


            // Withdraw
            else if (selectionLower.equals("w")) {
                System.out.println("\nEnter withdraw amount: ");
                double withdrawValue = scanner.nextDouble();

                // Error Check for negative withdraw
                while (withdrawValue <= 0) {
                    System.out.println("\nYou must withdraw at least $0.01");
                    System.out.println("Enter withdraw amount: ");
                    withdrawValue = scanner.nextDouble();
                }

                // Check for sufficient balance
                while (withdrawValue > currentBalance) {
                   System.out.println("\nInsufficient funds.");
                   System.out.println("Enter withdraw amount: ");
                   withdrawValue = scanner.nextDouble();
                }

                // Withdraw Calculation
                currentBalance = withdraw(currentBalance, withdrawValue);

                // Update total amount withdrawn
                totalWithdraw += withdrawValue;

                // Print updated balance after withdrawal with currency formatting
                System.out.println("\nYour new balance is: " + currency.format(currentBalance));
                System.out.println("---------------------------------------------------------------------------------");
            }


            // Current Balance
            else if (selectionLower.equals("c")) {
                // Print current balance
                System.out.println("\nYour current balance is: " + currency.format(currentBalance));
                System.out.println("---------------------------------------------------------------------------------");
            }


            // Leave
            else if (selectionLower.equals("l")){
                // Ask the user if they would like a receipt printed or emailed
                System.out.println("\nWould you like your receipt printed (p) or emailed (e)?");
                String receipt = scanner.next();

                // Modify receipt input to be lower case
                String receiptLower = receipt.toLowerCase();
                System.out.println();   // Spacing

                // Error check for receipt input
                while (!receiptLower.equals("p") && (!receiptLower.equals("e"))){   // while receipt input is not "p" and not "e"

                    // Inform user of invalid selection and ask for receipt input again
                    System.out.println("Invalid selection. Select p or e.");
                    receipt = scanner.next();

                    // Modify receipt input to be lower case
                    receiptLower = receipt.toLowerCase();

                    System.out.println();   // Spacing
                }

                // Remind user to take the receipt or check their email depending on the choice from above
                // If user selects a printed receipt
                if (receiptLower.equals("p")) {
                    System.out.println("Remember to take your receipt.");
                }

                // If user selects an emailed receipt
                else if (receiptLower.equals("e")) {
                    System.out.println("Your receipt will be emailed to the email address associated with your account.");
                }

                // Spacing for Output
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");

                // Print Total Withdrawn
                System.out.println("Total Amount Deposited: " + currency.format(totalDeposit));

                // Print Total Deposited
                System.out.println("Total Amount Withdrawn: " + currency.format(totalWithdraw));

                // Print thank you message
                System.out.println("\nThank you for using our ATM. Have a great day, " + userName + ".");
                System.out.println("---------------------------------------------------------------------------------");

                // Exit ATM menu
                proceed = leave();  // calls leave() method, making proceed false and ending while loop
            }

            // Error check for invalid menu input
            else{
                System.out.println("Please enter a valid option (d, w, c, or l).\n");
            }

        }   // End of ATM menu

        // Close Scanner
        scanner.close();

    }   // End of main method

} // End of Lab3 Class