""" Q8. Write a program that processes a nested dictionary of student records. Each student has a "name" and "marks" key. 
The "marks" key contains another dictionary with subject names as keys and scores as values.
Implement a function that:
Accepts the student dictionary and a subject name as input.
Returns the average marks for the given subject across all students.
Handles the following exceptions:
KeyError if a student's record does not have the subject.
TypeError if the "marks" field is not a dictionary.
ZeroDivisionError if no student has marks for the given subject. """
def calculate_subject_average(students, subject):
    total = 0
    count = 0
    for student_id, student_data in students.items():
        try:
            if not isinstance(student_data.get("marks"), dict):
                raise TypeError(f"Marks for student '{student_data.get('name', student_id)}' is not a dictionary.")
            mark = student_data["marks"][subject]
            total += mark
            count += 1
        except KeyError:
            print(f"KeyError: Subject '{subject}' not found for student '{student_data.get('name', student_id)}'.")
        except TypeError as e:
            print("TypeError:", e)
    try:
        average = total / count
        return average
    except ZeroDivisionError:
        print(f"ZeroDivisionError: No valid marks found for subject '{subject}'.")
        return None
students_data = {
    101: {"name": "Twinkle", "marks": {"Math": 85, "Science": 90}},
    102: {"name": "Karisma", "marks": {"Math": 78}},
    103: {"name": "Nish", "marks": {"English": 88}},
    104: {"name": "Sam", "marks": "not_a_dict"},
    105: {"name": "Ash", "marks": {"Math": 92, "Science": 87}},
}
subject = input("Enter subject to calculate average: ").strip()
average_score = calculate_subject_average(students_data, subject)
if average_score is not None:
    print(f"\nAverage marks for {subject}: {average_score:.2f}")