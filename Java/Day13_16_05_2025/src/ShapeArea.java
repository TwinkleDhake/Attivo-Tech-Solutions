/* Q3. Take user input and Write a program where a parent class Shape has a method area().
Override this method in child classes Circle and Rectangle to calculate their respective areas.
Use polymorphism to create objects dynamically and call the area() method. */
import java.util.Scanner;
abstract class Shape {
    abstract void area();
}
class Circle extends Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + result);
    }
}
class Rectangle extends Shape {
    double length, width;
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    void area() {
        double result = length * width;
        System.out.println("Area of Rectangle: " + result);
    }
}
public class ShapeArea {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Shape shape;
            System.out.print("Enter shape (circle/rectangle): ");
            String shapeType = scanner.nextLine().toLowerCase();
            switch (shapeType) {
                case "circle" -> {
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    shape = new Circle(radius);
                }
                case "rectangle" -> {
                    System.out.print("Enter length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    shape = new Rectangle(length, width);
                }
                default -> {
                    System.out.println("Unknown shape.");
                    scanner.close();
                    return;
                }
            }
            shape.area();
        }
    }
}