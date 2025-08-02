#Q3. Write a Python program that takes a student's grade as input and prints:
#"Excellent" for grades 90 and above.
#"Good" for grades between 70 and 89.
#"Needs Improvement" for grades below 70.
name = input("Enter your Name: ")
marks = int(input("Enter Your Marks: "))
if marks >= 90:
    print(name, "got", marks, "Excellent")
elif marks >= 70 and marks <= 89:
    print(name, "got", marks, "Good")
else:
    print(name, "got", marks, "Needs Improvement")