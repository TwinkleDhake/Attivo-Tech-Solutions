// Q2. Write a program to reverse the digits of a number using a while loop.
import java.util.Scanner;
public class WhileReverseNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            int originalNum = num;
            int reversed = 0;
            while (num != 0) {
                int digit = num % 10;           
                reversed = reversed * 10 + digit;
                num = num / 10;             
            }
            System.out.println("Reversed number of " + originalNum + " is: " + reversed);
            scanner.close();
        }
    }
}