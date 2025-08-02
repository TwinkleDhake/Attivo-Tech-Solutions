/* Q6. Create a class Patient with private fields:
name (String)
age (int)
ailment (String)
Add getter and setter methods. In the setter method for age, ensure that the age is between 0 and 120. 
Demonstrate the encapsulation by attempting to set invalid ages. */
class Patient {
    private String name;
    private int age;
    private String ailment;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Age must be between 0 and 120.");
        }
    }
    public String getAilment() {
        return ailment;
    }
    public void setAilment(String ailment) {
        this.ailment = ailment;
    }
}
public class EncapsulationPatient {
    public static void main(String[] args) {
        Patient patient = new Patient();
        patient.setName("John Smith");
        patient.setAge(35);
        patient.setAilment("Flu");
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
        System.out.println("Ailment: " + patient.getAilment());
        patient.setAge(-5);
        patient.setAge(150);
        System.out.println("Age after invalid attempts: " + patient.getAge());
    }
}