// Q1. Write a program that takes a number as input and prints its multiplication table up to 10.(for loop)
import java.util.Scanner;
public class ForMultiplication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            System.out.println("Multiplication table for " + num + ":");
            for (int i = 1; i <= 10; i++) {
                int result = num * i;
                System.out.println(num + " x " + i + " = " + result);
            }
            scanner.close();
        }
    }
}