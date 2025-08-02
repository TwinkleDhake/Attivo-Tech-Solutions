/* Q5. Write a Java program to create a class Car with private fields:
brand (String)
engine (another class, Engine)
The Engine class should have private fields:
horsepower (int)
type (String)
Provide getter and setter methods for all fields. Demonstrate usage in the main method. */
class Engine {
    private int horsepower;
    private String type;
    public int getHorsepower() {
        return horsepower;
    }
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
class Car {
    private String brand;
    private Engine engine;
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
public class EncapsulationCarEngine {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.setHorsepower(300);
        engine.setType("V6");
        Car car = new Car();
        car.setBrand("Endevour");
        car.setEngine(engine);
        System.out.println("Car Brand: " + car.getBrand());
        System.out.println("Engine Horsepower: " + car.getEngine().getHorsepower());
        System.out.println("Engine Type: " + car.getEngine().getType());
    }
}