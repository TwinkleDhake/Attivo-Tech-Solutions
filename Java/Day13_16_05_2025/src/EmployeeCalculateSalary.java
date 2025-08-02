/* Q4. Take user input and Write a program to demonstrate runtime polymorphism. Create a base class Employee with a method calculateSalary().
Create subclasses Manager and Developer that override the calculateSalary() method.
Use a base class reference to call the overridden methods. */
import java.util.Scanner;
class Employee {
    void calculateSalary() {
        System.out.println("Calculating salary for Employee");
    }
}
class Manager extends Employee {
    double basicSalary = 50000;
    @Override
    void calculateSalary() {
        double salary = basicSalary + (basicSalary * 0.2);
        System.out.println("Salary of Manager: " + salary);
    }
}
class Developer extends Employee {
    double basicSalary = 40000;
    @Override
    void calculateSalary() {
        double salary = basicSalary + (basicSalary * 0.1);
        System.out.println("Salary of Developer: " + salary);
    }
}
public class EmployeeCalculateSalary {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Employee employee;
            System.out.print("Enter employee type (manager/developer): ");
            String type = scanner.nextLine().toLowerCase();
            switch (type) {
                case "manager" -> employee = new Manager();
                case "developer" -> employee = new Developer();
                default -> {
                    System.out.println("Unknown employee type. Exiting.");
                    scanner.close();
                    return;
                }
            }
            employee.calculateSalary();
        }
    }
}