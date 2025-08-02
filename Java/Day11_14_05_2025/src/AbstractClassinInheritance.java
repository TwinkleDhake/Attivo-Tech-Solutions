/* Q8.⁠ ⁠Abstract Class in Inheritance
Create an abstract class Appliance with an abstract method turnOn().
Create a concrete class WashingMachine that extends Appliance and provides implementation for turnOn().
Task: Demonstrate the functionality of turnOn() for WashingMachine in the main method. */
abstract class Appliance {
    abstract void turnOn();
}
class WashingMachine extends Appliance {
    @Override
    void turnOn() {
        System.out.println("Washing machine is now ON.");
    }
}
public class AbstractClassinInheritance {
    public static void main(String[] args) {
        Appliance wm = new WashingMachine();
        wm.turnOn();
    }
}