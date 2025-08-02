#Q2. Q2. Write a Python program using match-case to print the name of the day when given an integer input (1 for Monday, 2 for Tuesday, ..., 7 for Sunday). If the input is not between 1 and 7, print "Invalid day."

Day = int(input("Enter a number (1-7): "))

match Day:
    case 1:
        print("Monday")
    case 2:
        print("Tuesday")
    case 3:
        print("Wednesday")
    case 4:
        print("Thursday")
    case 5:
        print("Friday")
    case 6:
        print("Saturday")
    case 7:
        print("Sunday")
    case _:
        print("Invalid day")