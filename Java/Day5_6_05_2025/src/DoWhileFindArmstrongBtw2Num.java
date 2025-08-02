// Q5. Write a program to find and print all Armstrong numbers between two numbers. (do-while)
/* An Armstrong number of n digits is a number such that the sum of its digits 
raised to the power n is equal to the number itself. */

import java.util.Scanner;
public class DoWhileFindArmstrongBtw2Num {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter starting number: ");
            int start = scanner.nextInt();
            System.out.print("Enter ending number: ");
            int end = scanner.nextInt();
            int num = start;
            System.out.println("Armstrong numbers between " + start + " and " + end + ":");
            do {
                int original = num;
                int sum = 0;
                int a = original;
                while (a != 0) {
                    int digit = a % 10;
                    sum += digit * digit * digit;
                    a /= 10;
                }
                if (sum == original) {
                    System.out.println(original);
                }
                num++;
            } while (num <= end);
            scanner.close();
        }
    }
}