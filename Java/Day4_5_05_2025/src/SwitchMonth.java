// Q3. Write a program that takes an integer (1-12) and outputs the name of the corresponding month.

import java.util.Scanner;
public class SwitchMonth {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number (1-12): ");
            int Month = scanner.nextInt();

            String MonthName;

            MonthName = switch (Month) {
                case 1 -> "January";
                case 2 -> "February";
                case 3 -> "March";
                case 4 -> "April";
                case 5 -> "May";
                case 6 -> "June";
                case 7 -> "July";
                case 8 -> "August";
                case 9 -> "September";
                case 10 -> "October";
                case 11 -> "November";
                case 12 -> "December";
                default -> "Invalid month number";
            };

            System.out.println("Month: " + MonthName);
            scanner.close();
        }
    }
}