""" Q7. Write a program that defines a class Employee with attributes name and salary, and a subclass Manager that adds an attribute department. 
Use __str__ method for formatted string representation and demonstrate inheritance and method overriding. """
class Employee:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
    def __str__(self):
        return f"Employee Name: {self.name}, Salary: ${self.salary:.2f}"
class Manager(Employee):
    def __init__(self, name, salary, department):
        super().__init__(name, salary)
        self.department = department
    def __str__(self):
        return f"Manager Name: {self.name}, Salary: ${self.salary:.2f}, Department: {self.department}"
emp = Employee("Alice", 50000)
mgr = Manager("Bob", 80000, "IT")
print(emp)
print(mgr)