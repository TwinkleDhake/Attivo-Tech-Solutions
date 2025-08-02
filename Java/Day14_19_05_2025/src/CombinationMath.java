/* Q5. Write a program that:
Prompts the user to enter two numbers as strings.
Converts these strings to integers and performs division.
Catch any NumberFormatException or ArithmeticException, and print an appropriate error message.
Create a class MathUtils with:
A static method factorial(int n) that calculates the factorial of a number.
Create a subclass AdvancedMathUtils that:
Contains a static method fibonacci(int n) to calculate the nth Fibonacci number.
Demonstrate the use of both methods in the main method. */

import java.util.Scanner;
class MathUtils {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
class AdvancedMathUtils extends MathUtils {
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("Fibonacci is not defined for negative numbers.");
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1, fib = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }
}
public class CombinationMath {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            String input1 = scanner.nextLine();
            System.out.print("Enter second number: ");
            String input2 = scanner.nextLine();
            try {
                int num1 = Integer.parseInt(input1);
                int num2 = Integer.parseInt(input2);
                int divisionResult = num1 / num2;
                System.out.println("Result of division: " + divisionResult);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid integers.");
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero is not allowed.");
            }
            int factNum = 5;
            int fibNum = 7;
            System.out.println("Factorial of " + factNum + " is " + MathUtils.factorial(factNum));
            System.out.println("Fibonacci number at position " + fibNum + " is " + AdvancedMathUtils.fibonacci(fibNum));    }
    }
}