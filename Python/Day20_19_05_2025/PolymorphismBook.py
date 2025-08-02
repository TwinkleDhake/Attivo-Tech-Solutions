""" Q1. Create a program where a class Book has attributes title and author, and a subclass EBook adds an additional attribute file_size. 
Override the __str__ method in both classes to return formatted strings. 
Demonstrate polymorphism by creating a list of Book and EBook objects and iterating through them to print details. """
class Book:
    def __init__(self, title, author):
        self.title = title
        self.author = author
    def __str__(self):
        return f"Book: '{self.title}' by {self.author}"
class EBook(Book):
    def __init__(self, title, author, file_size):
        super().__init__(title, author)
        self.file_size = file_size
    def __str__(self):
        return f"EBook: '{self.title}' by {self.author} ({self.file_size}MB)"
library = [
    Book("To Kill a Mockingbird", "Harper Lee"),
    EBook("1984", "George Orwell", 1.2),
    Book("Pride and Prejudice", "Jane Austen"),
    EBook("The Martian", "Andy Weir", 2.5)
]
for item in library:
    print(item)