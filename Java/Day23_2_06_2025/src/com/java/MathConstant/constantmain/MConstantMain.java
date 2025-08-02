/* Q4. Write a program to demonstrate the use of static import by creating a package com.example.constants 
containing a class MathConstants with static fields like PI and E. 
Use these constants in a separate program. */
package com.java.MathConstant.constantmain;
import static java.lang.StrictMath.E;
import static java.lang.StrictMath.PI;
import java.util.Scanner;
public class MConstantMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the radius of a circle: ");
            double radius = scanner.nextDouble();
            double circumference = 2 * PI * radius;
            double exponential = Math.pow(E, radius);
            System.out.println("Circumference of the circle: " + circumference);
            System.out.println("E raised to the power of radius: " + exponential);
        }
    }
}