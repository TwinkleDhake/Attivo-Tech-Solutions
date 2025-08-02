""" Q2. Create a program to manage student records. The program should allow users to:
Add a student (name, age, grade).
View all student records.
Search for a student by name.
Update a student's details.
Delete a student's record. """
students = []
def add_student():
    name = input("Enter student name: ")
    age = input("Enter student age: ")
    grade = input("Enter student grade: ")
    students.append({"name": name, "age": age, "grade": grade})
    print("Student added successfully.\n")
def view_students():
    if not students:
        print("No student records found.\n")
    else:
        print("\nAll Student Records:")
        for student in students:
            print(f"Name: {student['name']}, Age: {student['age']}, Grade: {student['grade']}")
        print()
def search_student():
    name = input("Enter name to search: ")
    found = False
    for student in students:
        if student['name'].lower() == name.lower():
            print(f"Found: Name: {student['name']}, Age: {student['age']}, Grade: {student['grade']}")
            found = True
            break
    if not found:
        print("Student not found.\n")
def update_student():
    name = input("Enter name of student to update: ")
    for student in students:
        if student['name'].lower() == name.lower():
            student['age'] = input("Enter new age: ")
            student['grade'] = input("Enter new grade: ")
            print("Student record updated.\n")
            return
    print("Student not found.\n")
def delete_student():
    name = input("Enter name of student to delete: ")
    for i, student in enumerate(students):
        if student['name'].lower() == name.lower():
            del students[i]
            print("Student deleted successfully.\n")
            return
    print("Student not found.\n")
def show_menu():
    print("Student Record Management")
    print("1. Add Student")
    print("2. View All Students")
    print("3. Search Student by Name")
    print("4. Update Student Details")
    print("5. Delete Student")
    print("6. Exit")
def student():
    while True:
        show_menu()
        choice = input("Enter your choice (1-6): ")
        if choice == "1":
            add_student()
        elif choice == "2":
            view_students()
        elif choice == "3":
            search_student()
        elif choice == "4":
            update_student()
        elif choice == "5":
            delete_student()
        elif choice == "6":
            print("Exiting program.")
            break
        else:
            print("Invalid choice. Please try again.\n")
if __name__ == "__main__":
    student()