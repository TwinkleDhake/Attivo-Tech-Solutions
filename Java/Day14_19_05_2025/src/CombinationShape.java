/* Q1. Write a Java program with an abstract class Shape that has:
An abstract method calculateArea().
A concrete method displayType() that prints the type of shape.
Create subclasses Circle and Rectangle that override calculateArea():
Circle should have a radius as an attribute.
Rectangle should have length and width as attributes.
Write a main method to:
Create instances of Circle and Rectangle.
Call calculateArea() and displayType() on both using polymorphism. */
abstract class Shape {
    public abstract double calculateArea();
    public void displayType() {
        System.out.println("This is a " + this.getClass().getSimpleName());
    }
}
class Circle extends Shape {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape {
    private final double length;
    private final double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculateArea() {
        return length * width;
    }
}
public class CombinationShape {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        circle.displayType();
        System.out.println("Area: " + circle.calculateArea());
        rectangle.displayType();
        System.out.println("Area: " + rectangle.calculateArea());
    }
}