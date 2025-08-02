/* Q4. Create a class Employee with the following private fields:
name (String)
salary (double)
Implement setter methods with validation rules:
salary should not be negative.
Write a main method to demonstrate these validations. */
class Employee {
    private String name;
    private double salary;
    public void setName(String name) {
        this.name = name; //instance variable
    }
    public String getName() {
        return name;
    }
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary! Salary cannot be negative.");
        }
    }
    public double getSalary() {
        return salary;
    }
}
public class EncapsulationEmployee {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setSalary(50000);
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Salary: $" + emp.getSalary());
        emp.setSalary(-10000);
        System.out.println("Salary after invalid update attempt: $" + emp.getSalary());
    }
}