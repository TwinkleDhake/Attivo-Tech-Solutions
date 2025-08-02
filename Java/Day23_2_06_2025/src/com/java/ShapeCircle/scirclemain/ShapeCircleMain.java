/* Q2. Create a package com.example.shapes. Define a class Circle with private, protected, public, and default members. 
Demonstrate the access of these members from a class inside and outside the package. */
package com.java.ShapeCircle.scirclemain;
import java.util.Scanner;
import com.java.ShapeCircle.scircle.Circle;
public class ShapeCircleMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter radius: ");
            double r = scanner.nextDouble();
            Circle c = new Circle(r);
            c.displayInfo();
            System.out.println("Color: " + c.color);
            System.out.println("Name: " + c.name); 
            System.out.println("Area: " + c.area);
        }
    }
}