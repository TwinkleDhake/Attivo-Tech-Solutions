/* Q8. Take user input and Create a list of objects of type Shape (base class) that contains instances of Circle, Rectangle, and Triangle (derived classes).
Use a loop to iterate through the list and call the draw() method, overridden in each subclass. */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class Shape {
    abstract void draw(); 
}
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}
class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }
}
public class ShapeList {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Shape> shapes = new ArrayList<>();
            System.out.print("How many shapes do you want to add? ");
            int count = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= count; i++) {
                System.out.print("Enter shape " + i + " (circle/rectangle/triangle): ");
                String shapeType = scanner.nextLine().toLowerCase();
                switch (shapeType) {
                    case "circle" -> shapes.add(new Circle());
                    case "rectangle" -> shapes.add(new Rectangle());
                    case "triangle" -> shapes.add(new Triangle());
                    default -> System.out.println("Unknown shape. Skipping...");
                }
            }
            System.out.println("\nDrawing all shapes:");
            for (Shape shape : shapes) {
                shape.draw();
            }
        }
    }
}