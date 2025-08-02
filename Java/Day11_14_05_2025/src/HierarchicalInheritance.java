/* Q3.⁠ ⁠Hierarchical Inheritance
Create a class Shape with a method area() that prints "Calculating area." Derive two classes:
Circle with a method radiusArea(double radius) that calculates the area of a circle.
Rectangle with a method rectArea(double length, double width) that calculates the area of a rectangle.
Task: Create objects of both Circle and Rectangle classes and calculate areas for given inputs. */
class Shape {
    void area() {
        System.out.println("Calculating area.");
    }
}
class Circle extends Shape {
    void radiusArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}
class Rectangle extends Shape {
    void rectArea(double length, double width) {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}
public class HierarchicalInheritance {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        circle.area();
        circle.radiusArea(5);

        rectangle.area();
        rectangle.rectArea(4, 7);
    }
}