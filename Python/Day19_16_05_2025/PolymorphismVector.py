""" Q4. Create a class Vector to represent a 2D vector. 
Overload the + operator to add two Vector objects and return a new Vector object. 
Demonstrate this functionality with examples. """
class Vector:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def __add__(self, other):
        if isinstance(other, Vector):
            return Vector(self.x + other.x, self.y + other.y)
        raise TypeError("Operands must be of type Vector")
    def __repr__(self):
        return f"Vector({self.x}, {self.y})"
v1 = Vector(3, 4)
v2 = Vector(1, 2)
result = v1 + v2
print(result)