""" Q2. Single Inheritance:
Create a base class Person with attributes name and age, and a method display() to print 
these attributes. Create a derived class Student that adds a new attribute student_id and overrides 
the display() method to include it. 
Test the functionality. """
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    def display(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")
class Student(Person):
    def __init__(self, name, age, student_id):
        super().__init__(name, age)
        self.student_id = student_id
    def display(self):
        super().display() 
        print(f"Student ID: {self.student_id}")
person = Person("Twinkle", 40)
student = Student("Sara", 20, "S12345")
print("Person Info:")
person.display()
print("\nStudent Info:")
student.display()