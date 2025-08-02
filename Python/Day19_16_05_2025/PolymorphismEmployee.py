""" Q5. Write a base class Employee with a method get_salary(). 
Derive two classes, FullTimeEmployee and PartTimeEmployee, and override the get_salary() method in each. 
Use a list of employees and a loop to print the salary of each type of employee. """
class Employee:
    def get_salary(self):
        raise NotImplementedError("Subclasses must implement get_salary()")
class FullTimeEmployee(Employee):
    def __init__(self, monthly_salary):
        self.monthly_salary = monthly_salary
    def get_salary(self):
        return self.monthly_salary
class PartTimeEmployee(Employee):
    def __init__(self, hourly_rate, hours_worked):
        self.hourly_rate = hourly_rate
        self.hours_worked = hours_worked
    def get_salary(self):
        return self.hourly_rate * self.hours_worked
employees = [
    FullTimeEmployee(5000),
    PartTimeEmployee(20, 80),
    FullTimeEmployee(6000),
    PartTimeEmployee(25, 60)
]
for index, emp in enumerate(employees, start=1):
    print(f"Employee {index} Salary: ${emp.get_salary()}")