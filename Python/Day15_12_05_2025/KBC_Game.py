""" Q6. "KBC game" such that display 5 options for a question and if option is correct then display the prize money won of 1000 and 
if option is selected is incorrect then display you lost the game and display as you lost the prize money of 1000 """
def kbc_game():
    print("Welcome to KBC!")
    print("Question: What is the capital of India?")
    print("1. Mumbai")
    print("2. Bangalore")
    print("3. Chennai")
    print("4. Hyderabad")
    print("5. New Delhi")
    try:
        choice = int(input("Enter your choice (1-5): "))
        if choice == 5:
            print("Correct Answer!")
            print("Congratulations! You have won ₹1000.")
        elif 1 <= choice <= 5:
            print("Wrong Answer.")
            print("You lost the game.")
            print("You lost the prize money of ₹1000.")
        else:
            print("Invalid input. Please enter a number between 1 and 5.")
    except ValueError:
        print("Invalid input. Please enter a valid number.")
kbc_game()