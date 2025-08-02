// Q5. Use the multi-catch feature to handle multiple exceptions in a single catch block.
import java.util.Scanner;
public class ExceptionHandlingMultiCatchEx {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.print("Enter an index to access a fruit (0 to 3): ");
                int index = Integer.parseInt(scanner.nextLine()); 
                System.out.println("Selected fruit: " + fruits[index]);  
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("Program continues after exception handling.");
        }
    }
}