// Q1. Write a calculator program using methods in java.
import java.util.Scanner;

    public class Calculator {
        public static double add(double a, double b) {
            return a + b;
        }
        public static double subtract(double a, double b) {
            return a - b;
        }
        public static double multiply(double a, double b) {
            return a * b;
        }
        public static double divide(double a, double b) {
            if (b == 0) {
                System.out.println("Error: Cannot divide by zero.");
                return Double.NaN;
            }
            return a / b;
        }    
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                boolean running = true;
                while (running) {
                    System.out.println("\n--- Java Calculator ---");
                    System.out.println("1. Add");
                    System.out.println("2. Subtract");
                    System.out.println("3. Multiply");
                    System.out.println("4. Divide");
                    System.out.println("5. Exit");
                    System.out.print("Choose an operation (1-5): ");                
                    int choice = scanner.nextInt();                    
                    if (choice >= 1 && choice <= 4) {
                        System.out.print("Enter first number: ");
                        double num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double num2 = scanner.nextDouble();                        
                        double result = 0;
                        switch (choice) {
                            case 1 -> result = add(num1, num2);
                            case 2 -> result = subtract(num1, num2);
                            case 3 -> result = multiply(num1, num2);
                            case 4 -> result = divide(num1, num2);
                        }
                        System.out.println("Result: " + result);
                    } else if (choice == 5) {
                        running = false;
                        System.out.println("Exiting Calculator. Goodbye!");
                    } else {
                        System.out.println("Invalid choice. Please select from 1 to 5.");
                    }
                }
            }
        }
    }