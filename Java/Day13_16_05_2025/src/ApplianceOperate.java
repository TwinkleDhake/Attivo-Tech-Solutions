/* Q7. Take user input and Create an abstract class Appliance with an abstract method operate().
Extend it into two classes: WashingMachine and AirConditioner.
Write a program that uses polymorphism to call the operate() method for different objects. */
import java.util.Scanner;
abstract class Appliance {
    abstract void operate();
}
class WashingMachine extends Appliance {
    @Override
    void operate() {
        System.out.println("Washing machine is operating...");
    }
}
class AirConditioner extends Appliance {
    @Override
    void operate() {
        System.out.println("Air conditioner is operating...");
    }
}
public class ApplianceOperate {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Appliance appliance;
            System.out.print("Enter appliance to operate (washingmachine/airconditioner): ");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "washingmachine" -> appliance = new WashingMachine();
                case "airconditioner" -> appliance = new AirConditioner();
                default -> {
                    System.out.println("Unknown appliance.");
                    scanner.close();
                    return;
                }
            }
            appliance.operate();
        }
    }
}