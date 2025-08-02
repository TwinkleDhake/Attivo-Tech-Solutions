/* Using Switch Case
Q1. Calculate Electricity Bill, Electricity rates are as follows:
For the first 100 units: ₹3/unit.
For the next 200 units: ₹5/unit.
Above 300 units: ₹7/unit. */

import java.util.Scanner;
public class SwitchElectricityBill {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of units consumed: ");
            int units = scanner.nextInt();
            int bill;

            int range = units / 100;
            bill = switch (range) {
                case 0 -> units * 3;
                case 1 -> 100 * 3 + (units - 100) * 5;
                case 2 -> 100 * 3 + 100 * 5 + (units - 200) * 5;
                default -> 100 * 3 + 200 * 5 + (units - 300) * 7;
            };
            System.out.println("Electricity bill for " + units + " units is Rs: " + bill);
            scanner.close();
        }
    }
}