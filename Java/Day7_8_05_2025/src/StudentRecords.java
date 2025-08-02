/* Q2. Create a program to manage student records. The program should allow users to:
Add a student (name, age, grade).
View all student records.
Search for a student by name.
Update a student's details.
Delete a student's record. */
import java.util.ArrayList;
import java.util.Scanner;
    class Student {
        String name;
        int age;
        String grade;
        Student(String name, int age, String grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age + ", Grade: " + grade;
        }
    }
    public class StudentRecords {
        private static final ArrayList<Student> students = new ArrayList<>();
        private static final Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
            while (true) {
                showMenu();
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateStudent();
                    case 5 -> deleteStudent();
                    case 6 -> {
                        System.out.println("Exiting program.");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            }
        }
        static void showMenu() {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
        }  
        static void addStudent() {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter grade: ");
            String grade = scanner.nextLine();
            students.add(new Student(name, age, grade));
            System.out.println("Student added successfully.");
        }
        static void viewStudents() {
            if (students.isEmpty()) {
                System.out.println("No student records available.");
            } else {
                System.out.println("\nAll Student Records:");
                for (Student s : students) {
                    System.out.println(s);
                }
            }
        }
        static void searchStudent() {
            System.out.print("Enter student name to search: ");
            String searchName = scanner.nextLine();
            boolean found = false;
            for (Student s : students) {
                if (s.name.equalsIgnoreCase(searchName)) {
                    System.out.println("Student found: " + s);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student not found.");
            }
        }
        static void updateStudent() {
            System.out.print("Enter student name to update: ");
            String name = scanner.nextLine();
            for (Student s : students) {
                if (s.name.equalsIgnoreCase(name)) {
                    System.out.print("Enter new age: ");
                    s.age = Integer.parseInt(scanner.nextLine());    
                    System.out.print("Enter new grade: ");
                    s.grade = scanner.nextLine();    
                    System.out.println("Student record updated.");
                    return;
                }
            }
            System.out.println("Student not found.");
        }
        static void deleteStudent() {
            System.out.print("Enter student name to delete: ");
            String name = scanner.nextLine();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).name.equalsIgnoreCase(name)) {
                    students.remove(i);
                    System.out.println("Student deleted successfully.");
                    return;
                }
            }
            System.out.println("Student not found.");
        }
    }