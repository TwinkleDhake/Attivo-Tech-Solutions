/* Q5.⁠ ⁠Hybrid Inheritance
Create a class Human with a method sleep().
Derive a class Student from Human with an additional method study().
Create an interface Athlete with a method play().
Implement the interface in Student.
Task: Demonstrate how a Student can access methods from both Human and Athlete in the main method. */
class Human {
    void sleep() {
        System.out.println("Human is sleeping.");
    }
}
interface Athlete {
    void play();
}
class Student extends Human implements Athlete {
    void study() {
        System.out.println("Student is studying.");
    }
    @Override
    public void play() {
        System.out.println("Student is playing sports.");
    }
}
public class HybridInheritance {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.sleep();
        s1.study(); 
        s1.play();
    }
}