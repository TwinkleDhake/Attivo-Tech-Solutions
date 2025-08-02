def hcf(a, b):
    while b!= 0:
        a, b = b, a % b
    return a
num1 = int(input("Enter the first number: "))
num2 = int(input("Enter the second number: "))
chcf = hcf(num1, num2)
print("The HCF of ", num1, num2, "is", chcf)