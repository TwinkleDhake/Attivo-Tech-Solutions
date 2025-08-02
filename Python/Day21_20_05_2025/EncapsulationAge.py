""" Q6. Write a class Age with a private attribute __age.
Add setter and getter methods with the following rules:
Age should be between 0 and 120.
Raise an exception for invalid values. """
class Age:
    def __init__(self, age):
        self.set_age(age)
    def get_age(self):
        return self.__age
    def set_age(self, age):
        if 0 <= age <= 120:
            self.__age = age
        else:
            raise ValueError("Age must be between 0 and 120.")
try:
    person = Age(25)
    print("Age is:", person.get_age())

    person.set_age(130)
except ValueError as e:
    print("Error:", e)