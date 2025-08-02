""" Q9. Write a program that defines an abstract class Shape with methods area() and perimeter(). 
Implement two subclasses, Circle and Rectangle, that override these methods. 
Demonstrate polymorphism using a list of Shape objects. """
from abc import ABC, abstractmethod
import math
class Shape(ABC):
    @abstractmethod
    def area(self):
        pass
    @abstractmethod
    def perimeter(self):
        pass
class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    def area(self):
        return math.pi * self.radius ** 2
    def perimeter(self):
        return 2 * math.pi * self.radius
    def __str__(self):
        return f"Circle with radius {self.radius}"
class Rectangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height
    def area(self):
        return self.width * self.height
    def perimeter(self):
        return 2 * (self.width + self.height)
    def __str__(self):
        return f"Rectangle {self.width} x {self.height}"
def display_shape_info(shapes):
    for shape in shapes:
        print(shape)
        print(f"Area: {shape.area():.2f}")
        print(f"Perimeter: {shape.perimeter():.2f}")
        print("-" * 30)
shapes = [
    Circle(5),
    Rectangle(4, 6),
    Circle(2.5),
    Rectangle(3, 7)
]
display_shape_info(shapes)