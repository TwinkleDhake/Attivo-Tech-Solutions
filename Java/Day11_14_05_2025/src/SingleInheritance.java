/* 1.⁠ ⁠Single Inheritance
Create a program in Java where a class Animal has a method eat() that prints "This animal eats food." Create another class Dog that inherits from Animal and adds a method bark() that prints "This dog barks."
Task: Demonstrate both methods in the main method. */
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}
class Dog extends Animal {
    void bark() {
        System.out.println("This dog barks.");
    }
}
public class SingleInheritance {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();
        myDog.bark();
    }
}