""" Q1. Write a base class Animal with a method sound(). 
Create two derived classes, Dog and Cat, and override the sound() method to return "Bark" and "Meow," respectively. 
Demonstrate polymorphism by creating a function that accepts an Animal object and calls its sound() method. """
class Animal:
    def sound(self):
        return "animal sound"
class Dog(Animal):
    def sound(self):
        return "bark"
class Cat(Animal):
    def sound(self):
        return "meow"
def sounds(animal):
    print(animal.sound())
a = Animal()
d = Dog()
c = Cat()
sounds(a)
sounds(d)
sounds(c)
