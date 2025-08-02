""" Q5. Implement a class CreditCard that hides sensitive information like the card number (__card_number).
Add a method display_masked_card that displays only the last 4 digits of the card number, masking the rest with *.
Example: If the card number is 1234567812345678, it should display ************5678. """
class CreditCard:
    def __init__(self, card_number):
        self.__card_number = card_number
    def display_masked_card(self):
        masked = '*' * 12 + self.__card_number[-4:]
        print("Card Number:", masked)
card = CreditCard("1234567812345678")
card.display_masked_card()