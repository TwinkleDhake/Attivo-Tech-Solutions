/* Q1. Write a program to create a package named com.example.math. 
Inside the package, create a class Calculator with methods for addition, subtraction, multiplication, and division. 
Use this package in another class to perform mathematical operations. */

package com.java.MathematicsCalculator.calmain;

import com.java.MathematicsCalculator.cal.Calculator;
import java.util.Scanner;

public class MainCalulator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Calculator cal = new Calculator();
            System.out.println("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.println("Enter second number: ");
            int num2 = scanner.nextInt();
            System.out.println("Choose operation: add, subtract, multiply, divide");
            String operation = scanner.next();
            switch (operation.toLowerCase()) {
                case "add" -> System.out.println("Result: " + cal.add(num1, num2));
                case "subtract" -> System.out.println("Result: " + cal.subtract(num1, num2));
                case "multiply" -> System.out.println("Result: " + cal.multiply(num1, num2));
                case "divide" -> {
                    try {
                        System.out.println("Result: " + cal.divide(num1, num2));
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                default -> System.out.println("Invalid operation");
            }
        }
    }
}