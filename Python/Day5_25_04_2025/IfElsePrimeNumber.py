n = int(input("Enter the Number: "))
if n == 2 or n == 3:
    print(n, "is a prime number")
elif n != 1 and n %2 != 0 and n % 3 != 0:
    print(n, "is a prime number")
else:
    print(n, "is not a prime number")