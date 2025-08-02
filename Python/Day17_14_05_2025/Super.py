""" Q6. Using super():
Create a base class Employee with a constructor that initializes name and salary. 
Create a derived class Manager that adds an attribute, department. 
Use super() to initialize attributes from the base class in the Manager class. """
class Employee:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
    def display(self):
        print(f"Name: {self.name}")
        print(f"Salary: ${self.salary}")
class Manager(Employee):
    def __init__(self, name, salary, department):
        super().__init__(name, salary)
        self.department = department
    def display(self):
        super().display()
        print(f"Department: {self.department}")
emp = Employee("Twinkle", 50000)
mgr = Manager("Kiara", 75000, "IT")
print("Employee Info:")
emp.display()
print("\nManager Info:")
mgr.display()