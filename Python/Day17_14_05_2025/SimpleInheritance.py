""" Q1. Simple Inheritance:
Write a Python program to create a base class Animal with a method speak() that prints "I make a sound." Create a derived class Dog that overrides the speak() method to print "I bark." 
Demonstrate calling the speak() method from both the base class and the derived class. """
class Animal:
    def speak(self):
        print("I make a sound.")
class Dog(Animal):
    def speak(self):
        print("I bark.")
generic_animal = Animal()
dog = Dog()
generic_animal.speak() 
dog.speak()
