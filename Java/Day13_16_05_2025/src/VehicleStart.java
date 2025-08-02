/* Q5. Take user input and Create an interface Vehicle with a method start().
Implement this interface in classes Car and Bike. Use polymorphism to call the start() method. */
import java.util.Scanner;
interface Vehicle {
    void start();
}
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }
}
class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting...");
    }
}
public class VehicleStart {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Vehicle vehicle;
            System.out.print("Enter vehicle type (car/bike): ");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "car" -> vehicle = new Car();
                case "bike" -> vehicle = new Bike();
                default -> {
                    System.out.println("Unknown vehicle type.");
                    scanner.close();
                    return;
                }
            }
            vehicle.start();
        }
    }
}