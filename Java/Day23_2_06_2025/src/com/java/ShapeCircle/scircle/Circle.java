package com.java.ShapeCircle.scircle;

public class Circle {
    private final double radius;
    public String color = "Red";
    public String name = "Circle";  
    public double area;              
    public Circle(double radius) {
        this.radius = radius;
        this.area = Math.PI * radius * radius;
    }
    public void displayInfo() {
        System.out.println("Radius (private): " + radius);
        System.out.println("Color (protected): " + color);
        System.out.println("Name (public): " + name);
        System.out.println("Area (default): " + area);
    }
}