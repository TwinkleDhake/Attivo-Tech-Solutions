/* Q2. Take user input and Create a parent class Animal with a method sound().
Create two child classes, Dog and Cat, which override the sound() method to provide specific implementations. */
import java.util.Scanner;
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
public class AnimalSound {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Animal animal;            
            System.out.print("Enter an animal (dog/cat): ");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "dog" -> animal = new Dog();
                case "cat" -> animal = new Cat();
                default -> {
                    System.out.println("Unknown animal. Defaulting to generic Animal.");
                    animal = new Animal();
                }
            }
            animal.sound();
        }
    }
}