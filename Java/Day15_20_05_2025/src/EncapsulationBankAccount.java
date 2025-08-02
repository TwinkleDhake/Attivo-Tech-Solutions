/* Q3. Write a class named BankAccount with the following private field:
password (String)
Provide only a setter method for the field. Show in the main method how the password can be set but not retrieved. */
class BankAccount {
    private String password;
    public void setPassword(String password) {
        this.password = password;
        System.out.println("Password has been set successfully.");
    }
}
public class EncapsulationBankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setPassword("Secure@123");
    }
}