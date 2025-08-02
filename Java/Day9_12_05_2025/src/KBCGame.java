/* Q4. "KBC game" such that display 5 options for a question and if option is correct then display the prize money won of 1000 and 
if option is selected is incorrect then display you lost the game and display as you lost the prize money of 1000 */
import java.util.Scanner;
public class KBCGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to KBC!");
            System.out.println("Question: What is the capital of India?");
            System.out.println("1. Mumbai");
            System.out.println("2. Bangalore");
            System.out.println("3. Chennai");
            System.out.println("4. Hyderabad");
            System.out.println("5. New Delhi");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            if (choice == 5) {
                System.out.println("Correct Answer!");
                System.out.println("Congratulations! You have won 1000/-.");
            } else if (choice >= 1 && choice <= 5) {
                System.out.println("Wrong Answer.");
                System.out.println("You lost the game.");
                System.out.println("You lost the prize money of 1000/-.");
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        }
    }
}