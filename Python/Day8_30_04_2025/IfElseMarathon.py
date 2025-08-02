#Q4. Write a Python program to determine if a person is eligible to participate in a marathon based on their age:
#If age is 18 or older, check their experience:
#If they have more than 2 years of running experience, print "Experienced Runner."
#Otherwise, print "Beginner Runner."

name = input("Enter your Name: ")
age = int(input("Enter You Age: "))
experience = int(input("Enter Your Experience: "))
#if (age >= 18):
if (age >= 18 and experience >= 2):
    print(name, "is a", "Experienced Runner")
elif (experience < 2 and experience >=1):
    print(name, "is a", "Beginner Runner")
else:
    print(name, "Your are", "not eligible to Run")