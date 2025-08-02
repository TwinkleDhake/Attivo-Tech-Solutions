""" Q3. Create a function calculate_area() that takes a shape object as an argument and calculates its area. Implement two shape classes, 
Rectangle (with length and width) and Circle (with radius), and define an area() method in both. 
Test the function with objects of both classes. """
import math
class Shape:
    def area(self):
        raise NotImplementedError("Subclasses must implement the area method.")
class Rectangle(Shape):
    def __init__(self, length, width):
        self.length = length
        self.width = width
    def area(self):
        return self.length * self.width
class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    def area(self):
        return math.pi * self.radius ** 2
def calculate_area(shape: Shape):
    return shape.area()
rect = Rectangle(10, 5)
circle = Circle(7)
print(f"Rectangle area: {calculate_area(rect)}")   
print(f"Circle area: {calculate_area(circle)}")