""" Q4. Encapsulation with Read-Only Attributes
Create a class Student with a private attribute __roll_number.
Allow only read access to __roll_number by using property decorators.
Demonstrate how trying to write to __roll_number raises an error. """
class Student:
    def __init__(self, roll_number):
        self.__roll_number = roll_number
    @property
    def roll_number(self):
        return self.__roll_number
student = Student(50)
print("Roll Number:", student.roll_number)
student.roll_number = 21
