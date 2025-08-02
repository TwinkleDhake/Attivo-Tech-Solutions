// Q1. Write a program with multiple catch blocks to handle different exceptions.
import java.util.Scanner;
public class ExceptionHandlingMultipleCatch {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first number: ");
            int n1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the second number: ");
            int n2 = Integer.parseInt(scanner.nextLine());
            int result = n1 / n2;
            System.out.println("Result: " + result);
            int[] num = {10, 20, 30};
            System.out.print("Enter an array index (0-2): ");
            int index = Integer.parseInt(scanner.nextLine());
            System.out.println("Element at index: " + num[index]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter integers only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}