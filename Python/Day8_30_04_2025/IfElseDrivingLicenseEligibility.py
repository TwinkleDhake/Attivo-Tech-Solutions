#Q2: Check if person is eligible for driving license?
name = input("Enter Your Name: ")
age = int(input("Enter Your Age: "))
if age >= 18:
    print(name, "You are eligible for Driving License")
else:
    print(name, "You are not eligible for Driving License")