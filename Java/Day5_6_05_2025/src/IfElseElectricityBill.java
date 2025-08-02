/* Using If-Else:
Q1. Calculate Electricity Bill, Electricity rates are as follows:
For the first 100 units: ₹3/unit.
For the next 200 units: ₹5/unit.
Above 300 units: ₹7/unit. */

import java.util.Scanner;

public class IfElseElectricityBill {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of units consumed: ");
            int units = scanner.nextInt();
            int bill;

            if (units <= 100) {
                bill = units * 3;
            } else if (units <= 300) {
                bill = 100 * 3 + (units - 100) * 5;
            } else {
                bill = 100 * 3 + 200 * 5 + (units - 300) * 7;
            }

            System.out.println("Electricity bill for " + units + " units is Rs: " + bill);
            scanner.close();
        }
    }    
}