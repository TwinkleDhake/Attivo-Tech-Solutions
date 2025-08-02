/* Q1. Write a Java program to create a Student class with the following features:
The class should have the fields name, rollNumber, and grade.
Implement:
A default constructor that initializes the fields to default values (e.g., "Unknown", 0, "Not assigned").
A parameterized constructor to initialize these fields with specific values.
Include a method displayDetails() to print the student information. */

import java.util.Scanner;
public class ConstructorStudentInformation {
    private final String name;
    private final int rollNumber;
    private final String grade;
    public ConstructorStudentInformation() {
        this.name = "Unknown";
        this.rollNumber = 0;
        this.grade = "Not assigned";
    }
    public ConstructorStudentInformation(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    public void displayDetails() {
        System.out.println("Students Details: ");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConstructorStudentInformation student1 = new ConstructorStudentInformation();
            student1.displayDetails();
            System.out.println(); 
            System.out.println("Enter student's name: ");
            String name = scanner.nextLine();
            System.out.println("Enter roll number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter grade: ");
            String grade = scanner.nextLine();
            ConstructorStudentInformation student2 = new ConstructorStudentInformation(name, rollNumber, grade);
            student2.displayDetails();
            scanner.close();
        }
    }
}