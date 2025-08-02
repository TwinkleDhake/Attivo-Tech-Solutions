/* Q7. Create a Java package, compile it, and create a JAR file for the package. 
Write a program to use the classes from the JAR file. */
package com.java.MathUtility.mathutilitymain;

import com.java.MathUtility.mutility.MathUtil;
import java.util.Scanner;

public class MathUtilityAppMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            System.out.println("Square: " + MathUtil.square(num));
            System.out.println("Cube: " + MathUtil.cube(num));
        }
    }
}