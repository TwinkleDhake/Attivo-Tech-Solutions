/* Q2. Write a program that demonstrates the use of Java packages by creating a package for geometric shapes and 
using it in another package to calculate the area of shapes.
Create a package named shapes containing two classes:
Circle with:
A public method calculateArea(double radius) that calculates and returns the area of a circle.
Formula: area = π * radius * radius.
Rectangle with:
A public method calculateArea(double length, double width) that calculates and returns the area of a rectangle.
Create another package named mainapp containing a class MainApp with a main method that:
Prompts the user to input the dimensions of a circle and a rectangle.
Uses the shapes.Circle and shapes.Rectangle classes to calculate and print their areas.
Requirements:
Use the import statement to access the shapes.Circle and shapes.Rectangle classes from the mainapp.MainApp class.
Ensure the methods in Circle and Rectangle are accessible from the MainApp class.
Hint:
Use the public modifier for the add method so that it can be accessed across packages. */

package com.java.mainareashapeapp;

import com.java.shapes.Circle;
import com.java.shapes.Rectangle;
import java.util.Scanner;

public class MainShapeArea {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter radius of the circle: ");
            double radius = scanner.nextDouble();
            System.out.print("Enter length of the rectangle: ");
            double length = scanner.nextDouble();
            System.out.print("Enter width of the rectangle: ");
            double width = scanner.nextDouble();
            Circle circle = new Circle();
            Rectangle rectangle = new Rectangle();
            double circleArea = circle.calculateArea(radius);
            double rectangleArea = rectangle.calculateArea(length, width);
            System.out.printf("Area of the circle: %.2f\n", circleArea);
            System.out.printf("Area of the rectangle: %.2f\n", rectangleArea);
        }
    }
}