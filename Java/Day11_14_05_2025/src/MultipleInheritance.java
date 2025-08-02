/* Q4.⁠ ⁠Multiple Inheritance Using Interfaces
Create two interfaces, Flyable and Swimmable, each with a method:
Flyable → fly().
Swimmable → swim().
Create a class Duck that implements both interfaces and provides definitions for fly() and swim().
Task: Demonstrate the use of the Duck class in the main method. */
interface Flyable {
    void fly();
}
interface Swimmable {
    void swim();
}
class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck is flying.");
    }
    @Override
    public void swim() {
        System.out.println("Duck is swimming.");
    }
}
public class MultipleInheritance {
    public static void main(String[] args) {
        Duck donald = new Duck();
        donald.fly();
        donald.swim();
    }
}