/* Q6. Take user input and Design a class hierarchy for a payment system:
Create a base class Payment with a method pay().
Derive CreditCardPayment and CashPayment classes, overriding the pay() method.
Demonstrate polymorphism by calling the pay() method using a Payment reference. */ 
import java.util.Scanner;
class Payment {
    void pay() {
        System.out.println("Processing payment...");
    }
}
class CreditCardPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Processing credit card payment...");
    }
}
class CashPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Processing cash payment...");
    }
}
public class PaymentSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Payment payment;            
            System.out.print("Enter payment method (credit/cash): ");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "credit" -> payment = new CreditCardPayment();
                case "cash" -> payment = new CashPayment();
                default -> {
                    System.out.println("Unknown payment method.");
                    scanner.close();
                    return;
                }
            }
            payment.pay();
        }
    }
}