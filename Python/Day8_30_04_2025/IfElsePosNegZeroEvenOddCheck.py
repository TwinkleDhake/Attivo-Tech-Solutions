#Q6. Write a Python program to classify a number as positive, negative, or zero. If the number is positive: Check if it is even or odd.

n = int(input("Enter the Number: "))
if n > 0:
    if n % 2 ==0:
        print(n, "is a Positive number and Even number")
    else:
        print(n, "is a positive number and Odd number")
elif n < 0:
    print(n, "is a Negative number")
else:
    print("The number is zero")