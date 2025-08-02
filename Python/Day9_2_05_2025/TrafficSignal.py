"""Q3. Write a program that simulates a traffic light system using match-case:
red: Print "Stop"
yellow: Print "Get ready"
green: Print "Go"
For any other input, print "Invalid light color."""

Traffic_Light = input("Enter Traffic Light color: ")

match Traffic_Light:
    case "red":
        print("Stop")
    case "yellow":
        print("Get ready")
    case "green":
        print("Go")
    case _:
        print("Invalid light color")