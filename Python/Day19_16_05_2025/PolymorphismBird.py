""" Q2. Implement a class Bird with a method fly(). Create another class Airplane with a method fly(). Write a function perform_flying() 
that accepts an object and calls its fly() method, showcasing duck typing in Python. """
class Flyable:
    def fly(self):
        raise NotImplementedError("Subclasses must implement this method")
class Bird(Flyable):
    def fly(self):
        print("The bird flaps its wings and flies.")
class Airplane(Flyable):
    def fly(self):
        print("The airplane soars through the sky.")
def perform_flying(flyable: Flyable):
    flyable.fly()
bird = Bird()
plane = Airplane()
perform_flying(bird)
perform_flying(plane)