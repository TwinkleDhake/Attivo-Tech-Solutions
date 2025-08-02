/* Q5. Create a package com.example.exceptions containing a custom exception class InvalidInputException. 
Write a program that uses this exception to handle invalid input. */
package com.java.Exceptions.inputvalidatormain;

import com.java.Exceptions.invalidinputexception.InValidEx;
import java.util.Scanner;
public class InValidMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a positive integer: ");
            int number = scanner.nextInt();
            if (number <= 0) {
                throw new InValidEx("Input must be a positive integer.");
            }
            System.out.println("You entered: " + number);
        } catch (InValidEx e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: Invalid input.");
        }
    }
}