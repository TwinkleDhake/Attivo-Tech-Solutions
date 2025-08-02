/* Q3. Write a program to define a Rectangle class with the following features:
Fields: length and width.
Constructors:
A default constructor that initializes the length and width to 1.
A parameterized constructor to initialize the length and width with user-provided values.
Methods:
calculateArea() to compute and return the area of the rectangle.
calculatePerimeter() to compute and return the perimeter of the rectangle. */
import java.util.Scanner;

class Rectangle {
    private final double length;
    private final double width;
    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double calculateArea() {
        return length * width;
    }
    public double calculatePerimeter() {
        return 2 * (length + width);
    }    
}
public class ConstructorRectangle {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the length of the rectangle: ");
            double length = scanner.nextDouble();
            System.out.println("Enter the width of the rectangle: ");
            double width = scanner.nextDouble();
            Rectangle rectangle = new Rectangle(length, width);
            System.out.println("Area of the rectangle: " + rectangle.calculateArea());
            System.out.println("Perimeter of the rectangle: " + rectangle.calculatePerimeter());
            scanner.close();
        }
    }
}