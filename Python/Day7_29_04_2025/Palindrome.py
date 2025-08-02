# Q1. Palindrome
n = int(input("Enter a String: "))
# n = int(input("Enter a Number: "))
rev = str[::-1]
if rev == str: #str(n) == str(n)[::1]:
    print("It ia a Palindrome")
else:
    print("It is not a Palindrome")
