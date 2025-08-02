""" Q6. Implement a class Person with methods to input and display details. 
Create a subclass Student with additional attributes roll_no and grades. 
Demonstrate multiple levels of inheritance by creating another class GraduateStudent with extra attributes research_topic. """
class Person:
    def __init__(self):
        self.name = ""
        self.age = 0
    def input_details(self):
        self.name = input("Enter name: ")
        self.age = int(input("Enter age: "))
    def display_details(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")
class Student(Person):
    def __init__(self):
        super().__init__()
        self.roll_no = ""
        self.grades = []
    def input_details(self):
        super().input_details()
        self.roll_no = input("Enter roll number: ")
        grades_input = input("Enter grades (comma-separated): ")
        self.grades = list(map(float, grades_input.split(',')))
    def display_details(self):
        super().display_details()
        print(f"Roll Number: {self.roll_no}")
        print(f"Grades: {self.grades}")
class GraduateStudent(Student):
    def __init__(self):
        super().__init__()
        self.research_topic = ""
    def input_details(self):
        super().input_details()
        self.research_topic = input("Enter research topic: ")
    def display_details(self):
        super().display_details()
        print(f"Research Topic: {self.research_topic}")
print("Enter details for a graduate student:")
grad_student = GraduateStudent()
grad_student.input_details()
print("\nGraduate Student Details:")
grad_student.display_details()