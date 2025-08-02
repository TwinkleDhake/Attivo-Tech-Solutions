""" Q4. Define a base class Animal with an abstract method speak(). 
Create subclasses Dog and Cat that implement the speak() method. 
Use a function that accepts a list of Animal objects to demonstrate polymorphism. """
from abc import ABC, abstractmethod
class Animal(ABC):
    @abstractmethod
    def speak(self):
        pass
class Dog(Animal):
    def speak(self):
        return "Woof!"
class Cat(Animal):
    def speak(self):
        return "Meow!"
def animal_sounds(animals):
    for animal in animals:
        print(animal.speak())
animals = [Dog(), Cat(), Dog(), Cat()]
animal_sounds(animals)