// Q4. Write a program to repeatedly ask the user for a positive number. If the user enters a negative number, prompt them again.
import java.util.Scanner;
public class DoWhileRepPosNum {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int num;
            do {
                System.out.print("Enter a positive number: ");
                num = scanner.nextInt();
                if (num < 0) {
                    System.out.println("That's a negative number. Please try again.");
                }
            } while (num < 0);
            System.out.println("You entered a positive number: " + num);
        }
    }    
}