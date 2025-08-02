// Q2. Create a program that handles a division-by-zero exception.
import java.util.Scanner;
public class ExceptionHandlingDivisionByZeroException {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            try {
                int result = numerator / denominator;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                // Handles division by zero
                System.out.println("Error: Cannot divide by zero!");
            }
            System.out.println("Program ended normally.");
        }
    }
}