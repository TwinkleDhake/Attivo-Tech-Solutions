/* 2.⁠ ⁠Multilevel Inheritance
Write a program with three classes:
Vehicle with a method startEngine().
Car that extends Vehicle and adds a method drive().
SportsCar that extends Car and adds a method race().
Task: Create an object of SportsCar in the main method and demonstrate the functionality of all three methods. */
class Vehicle {
    void startEngine() {
        System.out.println("Engine started.");
    }
}
class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving.");
    }
}
class SportsCar extends Car {
    void race() {
        System.out.println("SportsCar is racing.");
    }
}
public class MultilevelInheritance {
    public static void main(String[] args) {
        SportsCar mySportsCar = new SportsCar();
        mySportsCar.startEngine(); 
        mySportsCar.drive();        
        mySportsCar.race();       
    }
}