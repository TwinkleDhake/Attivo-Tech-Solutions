""" Q8. Abstract Base Classes (ABC):
Create an abstract base class Animal with an abstract method make_sound(). 
Create two derived classes, Cat and Dog, that implement the make_sound() method to print "Meow" and "Bark," respectively. 
Write a program to instantiate objects of both classes and call their make_sound() methods."""
from abc import ABC, abstractmethod
class Animal(ABC):
    @abstractmethod
    def make_sound(self):
        pass
class Cat(Animal):
    def make_sound(self):
        print("Meow")
class Dog(Animal):
    def make_sound(self):
        print("Bark")
cat = Cat()
dog = Dog()
cat.make_sound()
dog.make_sound()
