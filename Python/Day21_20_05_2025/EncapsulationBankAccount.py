""" Q1. Create a Class with Private Attributes
Write a Python class BankAccount with the following private attributes:
__account_number (integer)
__balance (float)
Include methods to set and get these private attributes. """
class BankAccount:
    def __init__(self, account_number, balance):
        self.__account_number = account_number
        self.__balance = balance
    def set_account_number(self, number):
        self.__account_number = number
    def get_account_number(self):
        return self.__account_number
    def set_balance(self, amount):
        self.__balance = amount
    def get_balance(self):
        return self.__balance