package org.example;
import java.util.Scanner;

public class CalculatorInterface {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        boolean entry = true;

        while (entry) {
            System.out.println("=== Calculator Application Menu ===");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Logarithm");
            System.out.println("4. Power");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter a non-negative number: ");
                int num = sc.nextInt();
                if (num < 0) {
                    System.out.println("Error: Square root is not defined for negative numbers.");
                } else {
                    System.out.println("√" + num + " = " + calculator.squareRoot(num));
                }
            } else if (choice == 2) {
                System.out.print("Enter a non-negative integer: ");
                int num = sc.nextInt();
                if (num < 0) {
                    System.out.println("Error: Factorial is not defined for negative numbers.");
                } else {
                    System.out.println(num + "! = " + calculator.factorial(num));
                }
            } else if (choice == 3) {
                System.out.print("Enter a number greater than 0: ");
                int num = sc.nextInt();
                if (num <= 0) {
                    System.out.println("Error: Natural logarithm is only defined for positive numbers.");
                } else {
                    System.out.println("ln(" + num + ") = " + calculator.naturalLog(num));
                }
            } else if (choice == 4) {
                System.out.print("Enter base: ");
                int base = sc.nextInt();
                System.out.print("Enter exponent: ");
                int exp = sc.nextInt();
                System.out.println(base + "^" + exp + " = " + calculator.powerFunction(base, exp));
            }
            else if (choice == 5) {
                entry = false;
                System.out.println("Exiting The Calculator Application");
            }
            else {
                System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }
        sc.close();
    }
}
