""" Q7. Create a parent class Account with private attributes __username and __password.
Write methods to set and get these attributes.
Create a child class AdminAccount that overrides the set_password method to enforce a strong password policy 
(e.g., at least 8 characters, including a number and a special character). """
import re
class Account:
    def __init__(self, username, password):
        self.__username = username
        self.__password = password
    def get_username(self):
        return self.__username
    def set_username(self, username):
        self.__username = username
    def get_password(self):
        return self.__password
    def set_password(self, password):
        self.__password = password
class AdminAccount(Account):
    def set_password(self, password):
        if (len(password) >= 8 and #checks if the password is at least 8 characters long
            re.search(r'\d', password) and #looks for a match anywhere in the string 
            # \d is a regular expression that matches any digit (0–9)
            # checks if the password contains at least one number
            re.search(r'[!@#$%^&*(),.?":{}|<>]', password)): # regex checks if the password contains at least one special character
            super().set_password(password) # calling the set_password method from the parent class
        else:
            raise ValueError("Password must be at least 8 characters long, include a number and a special character.")
try:
    admin = AdminAccount("admin_user", "Admin@123")
    print("Admin username:", admin.get_username())
    print("Admin password:", admin.get_password())

    admin.set_password("weak")
except ValueError as e:
    print("Error:", e)