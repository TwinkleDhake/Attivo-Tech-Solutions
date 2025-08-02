""" Q8. Create a class CustomString that inherits from Python's str class. 
Override the __add__() method to concatenate strings with a space in between and implement a 
custom method reverse() to return the reverse of the string. """
class CustomString(str):
    def __add__(self, other):
        return CustomString(super().__add__(' ' + str(other)))
    def reverse(self):
        return self[::-1]
s1 = CustomString("Hello")
s2 = CustomString("World")
combined = s1 + s2
print("Concatenated:", combined)
reversed_string = combined.reverse()
print("Reversed:", reversed_string)