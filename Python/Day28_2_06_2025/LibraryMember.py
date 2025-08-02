""" Q1. Classes and Inheritance:
Create a base class LibraryMember.
Attributes: member_id, name, borrowed_books (a list to track borrowed books).
Methods: borrow_book(book), return_book(book).
Create two derived classes:
RegularMember: Can borrow up to 3 books at a time.
PremiumMember: Can borrow up to 5 books at a time. """

class LibraryMember:
    def __init__(self, member_id, name):
        self.member_id = member_id
        self.name = name
        self.borrowed_books = []
    def borrow_book(self, book):
        raise NotImplementedError("Subclasses must implement this method.")
    def return_book(self, book):
        if book in self.borrowed_books:
            self.borrowed_books.remove(book)
            print(f"{self.name} has returned '{book}'.")
        else:
            print(f"{self.name} has not borrowed '{book}'.")
class RegularMember(LibraryMember):
    MAX_BOOKS = 3
    def borrow_book(self, book):
        if len(self.borrowed_books) < self.MAX_BOOKS:
            self.borrowed_books.append(book)
            print(f"{self.name} has borrowed '{book}'.")
        else:
            print(f"{self.name} has reached the borrow limit of {self.MAX_BOOKS} books.")
class PremiumMember(LibraryMember):
    MAX_BOOKS = 5
    def borrow_book(self, book):
        if len(self.borrowed_books) < self.MAX_BOOKS:
            self.borrowed_books.append(book)
            print(f"{self.name} has borrowed '{book}'.")
        else:
            print(f"{self.name} has reached the borrow limit of {self.MAX_BOOKS} books.")
if __name__ == "__main__":
    member_type = input("Enter member type (regular/premium): ").strip().lower()
    member_id = int(input("Enter member ID: "))
    name = input("Enter member name: ")
    if member_type == "regular":
        member = RegularMember(member_id, name)
    elif member_type == "premium":
        member = PremiumMember(member_id, name)
    else:
        print("Invalid member type. Exiting.")
        exit()
    while True:
        action = input("\nChoose action: borrow, return, show, quit: ").strip().lower()
        if action == "borrow":
            book = input("Enter book to borrow: ")
            member.borrow_book(book)
        elif action == "return":
            book = input("Enter book to return: ")
            member.return_book(book)
        elif action == "show":
            print(f"{member.name}'s borrowed books: {member.borrowed_books}")
        elif action == "quit":
            print("Goodbye!")
            break
        else:
            print("Invalid action. Try again.")