//Q1. Take two numbers as input form the user for doing arithemetic operations like +, -, *.

import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the First number: ");
            int n1 = scanner.nextInt();
            System.out.println("Enter the Second number: ");
            int n2 = scanner.nextInt();
            int addition = n1 + n2;
            int subtraction = n1 - n2;
            int multiplication = n1 * n2;
            System.out.println("Addition: " + n1 + " + " + n2 + " = " + addition);
            System.out.println("Subtraction: " + n1 + " - " + n2 + " = " + subtraction);
            System.out.println("Multiplication: " + n1 + " * " + n2 + " = " + multiplication);
        }
    }    
}