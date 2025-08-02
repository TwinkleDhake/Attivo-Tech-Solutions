/* Q2. Create a class Person with the following:
Private fields for name (String) and age (int).
A constructor to initialize these fields.
A method getDetails() that returns a formatted string with the name and age.
Extend Person to create a class Student with:
An additional field grade (String).
Override getDetails() to include the grade.
In the main method, demonstrate the use of getDetails() for both Person and Student. */
class Person {
    private final String name;
    private final int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getDetails() {
        return "Name: " + name + ", Age: " + age;
    }
}
class Student extends Person {
    private final String grade;
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    @Override
    public String getDetails() {
        return super.getDetails() + ", Grade: " + grade;
    }
}
public class CombinationPersonStudent {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        Student student = new Student("Bob", 20, "A");
        System.out.println(person.getDetails());
        System.out.println(student.getDetails());
    }
}