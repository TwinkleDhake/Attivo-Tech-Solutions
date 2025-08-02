// Q3. Write a program to find the GCD of two numbers using a while loop.
import java.util.Scanner;
public class WhileGCDnumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first number: ");
            int n1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int n2 = scanner.nextInt();
            int a = n1;
            int b = n2;
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            System.out.println("GCD of " + n1 + " and " + n2 + " is: " + a);
            scanner.close();
        }
    }
}