/* Q3. Create a package com.example.animals.mammals and define a class Elephant. 
Add another class in a sub-package com.example.animals.birds called Parrot. 
Write a main class to use both sub-packages. */
package com.java.Mammals.mammalsmain;
import com.java.Mammals.wildanimals.animals.Elephant;
import com.java.Mammals.wildanimals.birds.Parrot;
import java.util.Scanner;
public class AnimalsMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an animal (1 - Elephant, 2 - Parrot): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    Elephant elephant = new Elephant();
                    elephant.sound();
                }
                case 2 -> {
                    Parrot parrot = new Parrot();
                    parrot.sound();
                }
                default -> System.out.println("Invalid choice.");
            }
            scanner.close();
        }
    }
}