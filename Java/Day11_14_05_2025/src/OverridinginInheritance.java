/* Q6.⁠ ⁠Overriding in Inheritance
Create a parent class Employee with a method work() that prints "Employee works 8 hours." Create a child class Manager that overrides work() to print "Manager works 10 hours."
Task: Use polymorphism to call the work() method for both an Employee and a Manager object. */
class Employee {
    void work() {
        System.out.println("Employee works 8 hours.");
    }
}
class Manager extends Employee {
    @Override
    void work() {
        System.out.println("Manager works 10 hours.");
    }
}
public class OverridinginInheritance {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Employee mgr = new Manager();
        emp.work();
        mgr.work();
    }
}