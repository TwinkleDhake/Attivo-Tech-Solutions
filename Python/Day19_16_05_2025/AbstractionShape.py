""" Q6. Create an abstract base class Shape with an abstract method area(). 
Implement two derived classes, Square and Triangle, and provide their specific implementations of area(). 
Use the abc module to enforce the abstract base class. """
from abc import ABC, abstractmethod
class Shape(ABC):
    @abstractmethod
    def area(self):
        pass
class Square(Shape):
    def __init__(self, side):
        self.side = side
    def area(self):
        return self.side ** 2
class Triangle(Shape):
    def __init__(self, base, height):
        self.base = base
        self.height = height
    def area(self):
        return 0.5 * self.base * self.height
shapes = [
    Square(4),
    Triangle(5, 3),
    Square(7),
    Triangle(10, 6)
]
for index, shape in enumerate(shapes, start=1):
    print(f"Shape {index} Area: {shape.area()}")