/* Q7. Create a base class Person with private fields:
name (String)
age (int)
Provide getter and setter methods for these fields.
Create a subclass Student that inherits from Person and has an additional private field grade (String) with getter and setter methods. 
Demonstrate usage in the main method. */
class Person {
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
class Student extends Person {
    private String grade;
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
public class InheritanceEncapsulationPerson {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Twinkle");
        student.setAge(28);
        student.setGrade("A");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grade: " + student.getGrade());
    }
}