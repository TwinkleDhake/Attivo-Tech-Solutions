/* Q1. Write a Java program to create a class called Student with the following private fields:
name (String)
rollNumber (int)
grade (char)
Provide getter and setter methods for all these fields. Test your class in a main method by setting values and then printing them. */
class Student {
    private String name;
    private int rollNumber;
    private char grade;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public char getGrade() {
        return grade;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }
}
public class EncapsulationStudent {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Emma");
        student.setRollNumber(202);
        student.setGrade('A');
        System.out.println("Student Name: " + student.getName());
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Grade: " + student.getGrade());
    }
}