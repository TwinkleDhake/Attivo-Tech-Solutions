""" Q8. Write a class User that stores private attributes __email and __password.
Add a method login(email, password) that validates the credentials.
Ensure that the password is stored in a hashed format (use Python's hashlib module).
Add methods to set and get the email (password should not have a getter method). """
import hashlib
class User:
    def __init__(self, email, password):
        self.__email = email
        self.__password = self.__hash_password(password)
    def __hash_password(self, password):
        return hashlib.sha256(password.encode()).hexdigest()
    def set_email(self, email):
        self.__email = email
    def get_email(self):
        return self.__email
    def set_password(self, password):
        self.__password = self.__hash_password(password)
    def login(self, email, password):
        hashed_input = self.__hash_password(password)
        if self.__email == email and self.__password == hashed_input:
            return True
        else:
            return False
user = User("user@example.com", "securePass123!")
print("Email:", user.get_email())
print("Login success:", user.login("user@example.com", "securePass123!"))
print("Login success:", user.login("user@example.com", "wrongPass"))
user.set_email("newuser@example.com")
print("Updated Email:", user.get_email())