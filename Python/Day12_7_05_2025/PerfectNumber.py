""" Q4. Write a program to check if a number is a perfect number (sum of its proper divisors equals the number). 
Continue checking new numbers until the user enters 0."""
while True:
    num = int(input("Enter a Number (0 to Quit): "))
    if num == 0:
        print("Exit")
        break
    if num < 0:
        print("Enter a Positive Number.")
        continue
    divisorsum = 0
    for i in range(1, num):
        if num % i == 0:
            divisorsum += i
    if divisorsum == num:
        print(num, "is a Perfect Number.")
    else:
        print(num, "is NOT a Perfect Number.")