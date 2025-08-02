# Q1. Develop a program to catch a KeyError when trying to access a non-existent key in a dictionary.
def exception_handle_key_error():
    student_scores = {
        "Twinkle": 85,
        "Karisma": 92,
        "Sam": 78
    }
    try:
        name = input("Enter student name to get score: ")
        score = student_scores[name]
        print(f"{name}'s score is: {score}")
    except KeyError:
        print(f"Error: '{name}' not found in the student records.")
exception_handle_key_error()