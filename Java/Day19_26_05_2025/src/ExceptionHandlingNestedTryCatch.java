// Q2. Demonstrate the use of nested try-catch blocks.
import java.util.Scanner;
public class ExceptionHandlingNestedTryCatch {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name);
            try {
                System.out.print("Enter your age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("You are " + age + " years old.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Age must be a number.");
            }
            try {
                int[] scores = {80, 90, 100};
                System.out.print("Enter index to see score (0-2): ");
                int index = Integer.parseInt(scanner.nextLine());
                System.out.println("Score at index " + index + ": " + scores[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index out of bounds.");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}