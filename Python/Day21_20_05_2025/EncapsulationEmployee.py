""" Q3. Write a class Employee with a private attribute __salary.
Use the @property decorator to create a getter method.
Use the @<attribute>.setter decorator to set the value of __salary.
Ensure that the salary cannot be set to a negative value. """
class Employee:
    def __init__(self, salary):
        self.__salary = salary
    @property
    def salary(self):
        return self.__salary
    @salary.setter
    def salary(self, value):
        if value < 0:
            print("Error: Salary cannot be negative.")
        else:
            self.__salary = value
emp = Employee(10000)
print("Current Salary:", emp.salary)
emp.salary = 50000
print("Updated Salary:", emp.salary)
emp.salary = -5000