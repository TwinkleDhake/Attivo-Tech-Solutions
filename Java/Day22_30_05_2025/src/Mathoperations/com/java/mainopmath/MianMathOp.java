/* Q1. Write a program that demonstrates the use of Java packages by creating two packages and sharing data between them.
Create a package named mathoperations containing a class Addition with a method add(int a, int b) that returns the sum of two integers.
Create another package named mainapp containing a class MainApp with a main method that:
Creates an object of the Addition class.
Calls the add method to calculate the sum of two numbers.
Prints the result to the console.
Requirements:
Use the import statement to access the mathoperations.Addition class from the mainapp.MainApp class.
Ensure the add method is accessible from the MainApp class.

Example Output
Input:
First number: 10
Second number: 20
Output:
python
Copy
Edit
The sum of 10 and 20 is: 30 
Hint:
Use the public modifier for the add method so that it can be accessed across packages. */

package com.java.mainopmath;

import com.java.mathoperations.Addition;
import java.util.Scanner;

public class MianMathOp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("First number: ");
            int num1 = scanner.nextInt();
            System.out.print("Second number: ");
            int num2 = scanner.nextInt();
            Addition addition = new Addition();
            int result = addition.add(num1, num2);
            System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result);
        }
    }
}