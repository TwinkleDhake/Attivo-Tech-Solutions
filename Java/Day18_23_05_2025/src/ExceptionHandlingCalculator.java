/* Q. Write a Java program that acts as a calculator and performs the following operations: addition, subtraction, multiplication, and division. The user should input the operation and two numbers.
However, the program must be able to handle the following exceptions using try-catch blocks:
1.	Invalid operator input – if the user enters an operator other than +, -, *, or /, handle an IllegalArgumentException with an appropriate message.
2.	Non-numeric input – if the user inputs something that is not a number for the operands, catch and handle the InputMismatchException .
3.	Division by zero – handle ArithmeticException with a custom error message gracefully.
4.	General exception – catch any other unforeseen exception. */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingCalculator {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {                    
                    System.out.print("Enter an operator (+, -, *, /) or type 'quit' to exit: "); // prompts user to select operator or quit
                    String operator = scanner.next();
                    if (operator.equalsIgnoreCase("quit")) {
                        System.out.println("Calculator exited.");
                        break;
                    }               
                    switch (operator) {
                        case "+", "-", "*", "/" -> {                            
                            System.out.print("Enter the first number: "); // prompts user to enter first number
                            double n1 = scanner.nextDouble();
                            System.out.print("Enter the second number: "); // prompts user to enter second number
                            double n2 = scanner.nextDouble();
                            double result;                            
                            switch (operator) {
                                case "+" -> result = n1 + n2;
                                case "-" -> result = n1 - n2;
                                case "*" -> result = n1 * n2;
                                case "/" -> {
                                    if (n2 == 0) {
                                        throw new ArithmeticException("Cannot divide by zero.");
                                    }
                                    result = n1 / n2;
                                }
                                default -> throw new IllegalStateException("Unexpected operator.");
                            }
                            System.out.println("Result: " + result);
                        }
                        default -> throw new IllegalArgumentException("Invalid operator. Only +, -, *, / are allowed.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter numeric values only.");
                    scanner.nextLine(); // input buffer is cleared
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }
            }
        }
    }
}