import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Project: simple-banking-system
 * Author: iamjdribleza89
 * Created on: 8/3/2025 at 11:32 AM
 */

public class Main {

    private static int currentBalance = 5000;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        displayMainWindow(scanner);
    }

    private static void displayMainWindow(Scanner scanner){
        int selectedOption = 0;

        do{
            System.out.println("\nWhat would you like to do?");
            System.out.println("1 - Withdraw, 2 - Check Balance, 3 - Deposit");

            try{
                selectedOption = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Enter number only.");
            }
        }while(selectedOption > 4);

        setOption(scanner, selectedOption);
    }

    private static void setOption(Scanner scanner, int selectedOption){
        switch (selectedOption) {
            case 1 -> withdraw(scanner);
            case 2 -> checkBalance(scanner);
            case 3 -> deposit(scanner);
            default -> displayMainWindow(scanner);
        }
    }

    private static void withdraw(Scanner scanner){
        int amount = 0;
        boolean invalidInput = false;
        do{
            System.out.println("WITHDRAW");
            System.out.println("Enter amount:");
            try{
                amount = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid Input! Enter number only.");
                invalidInput = true;
            }
        }while(invalidInput);

        while (amount > currentBalance){
            System.out.println("Insufficient Balance!");
            System.out.println("Enter amount:");
            amount = scanner.nextInt();
        }

        currentBalance -= amount;

        System.out.println("You withdrew " + amount);
        checkBalance(scanner); // display current balance

        displayMainWindow(scanner);
    }

    private static void checkBalance(Scanner scanner){
        System.out.println("Your current balance is " + currentBalance);
        displayMainWindow(scanner);
    }

    private static void deposit(Scanner scanner){
        int amount = 0;
        do{
            System.out.println("DEPOSIT");
            System.out.println("Enter amount");
            try{
                amount= scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Enter number only.");
            }
        }while(amount < 1);

        // update current balance
        currentBalance += amount;

        System.out.println("You have successfully deposited " + amount);
        checkBalance(scanner);

        // display main option
        displayMainWindow(scanner);
    }
}
