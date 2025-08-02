""" Q4. Hierarchical Inheritance:
Create a base class Shape with a method area() that prints "Area not defined." 
Create two derived classes, Circle and Rectangle.
The circle should calculate and print the area using the radius.
The rectangle should calculate and print the area using length and width."""
import math
class Shape:
    def area(self):
        print("Area not defined.")
class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    def area(self):
        area = math.pi * self.radius ** 2
        print(f"Circle Area: {area:.2f}")
class Rectangle(Shape):
    def __init__(self, length, width):
        self.length = length
        self.width = width
    def area(self):
        area = self.length * self.width
        print(f"Rectangle Area: {area}")
circle = Circle(radius=5)
rectangle = Rectangle(length=4, width=6)
circle.area()      
rectangle.area()   
