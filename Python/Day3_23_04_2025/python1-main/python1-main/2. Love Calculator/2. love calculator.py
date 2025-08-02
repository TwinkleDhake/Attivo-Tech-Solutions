def calculate_love_score(name1, name2):
    # Combine the names and convert to lowercase
    combined_names = (name1 + name2).lower()
    
    # Calculate the LOVE score using a more complex formula
    score = 0
    for letter in 'love':
        score += combined_names.count(letter) * 10
    
    # Ensure the score is between 0 and 100
    love_score = score % 101
    return love_score

def main():
    print("Welcome to the Love Calculator!")

    # Get names from the user
    name1 = input("Enter the first person's name: ")
    name2 = input("Enter the second person's name: ")

    # Validate input
    if not name1 or not name2:
        print("Please enter both names.")
        return

    # Calculate the love score
    love_score = calculate_love_score(name1, name2)

    # Display the love score
    print(f"The love compatibility score for {name1} and {name2} is: {love_score}%")

if __name__ == "__main__":
    main()
