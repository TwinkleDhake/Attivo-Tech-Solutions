#Q5. Write a Python program to check if a number is positive or negative. Print the result accordingly.

n = int(input("Enter the Number: "))
if n > 0:
    print(n, "is a Positive number")
elif n < 0:
    print(n, "is a negative number")
else:
    print("The number is zero")