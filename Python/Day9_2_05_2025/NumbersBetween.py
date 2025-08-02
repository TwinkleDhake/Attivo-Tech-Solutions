# Q1. Take input from user and Write a program to check whether a given number is within the range of 0-25, 25 - 50, 50-75, 75-100 and is also even.
n = int(input("Enter the Number between 0 and 100: "))
if n % 2 == 0:
    if 0 <= n <25:
        print("The number", n, "is Even and in range 0-25")
    elif 25 <= n <= 50:
        print("The number", n, "is Even and in range 25-50")
    elif 50 <= n <= 75:
        print("The number", n, "is Even and in range 50-75")
    elif 75 <= n <= 100:
        print("The number", n, "is Even and in range 75-100")
else:
    print("The number", n, "is Not Even")