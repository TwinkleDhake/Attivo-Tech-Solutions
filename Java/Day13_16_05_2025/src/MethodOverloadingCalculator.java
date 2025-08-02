/* Q1. Overloading Example
Write a program to demonstrate method overloading. Create a class Calculator with multiple add methods to handle:
Two integers
Two doubles
Three integers
Take user input. */
import java.util.Scanner;
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }
}
public class MethodOverloadingCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Calculator calc = new Calculator();
            System.out.println("Choose operation:");
            System.out.println("1. Add two integers");
            System.out.println("2. Add two doubles");
            System.out.println("3. Add three integers");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter first integer: ");
                    int a1 = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int b1 = scanner.nextInt();
                    System.out.println("Result: " + calc.add(a1, b1));
                }
                case 2 -> {
                    System.out.print("Enter first double: ");
                    double a2 = scanner.nextDouble();
                    System.out.print("Enter second double: ");
                    double b2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.add(a2, b2));
                }   
                case 3 -> {
                    System.out.print("Enter first integer: ");
                    int a3 = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int b3 = scanner.nextInt();
                    System.out.print("Enter third integer: ");
                    int c3 = scanner.nextInt();
                    System.out.println("Result: " + calc.add(a3, b3, c3));
                }   
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}