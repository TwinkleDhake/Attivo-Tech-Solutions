// Q2. Write a program that takes the month number (1-12) and prints the number of days in that month. Consider leap years for February.

import java.util.Scanner;
public class SwitchMonthsDates {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter month number (1-12): ");
            int month = scanner.nextInt();
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            int days;
            
            switch (month) {
                case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
                case 4,    6, 9, 11 -> days = 30;
                case 2 ->  {
                // Check for leap year
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                }
                default -> {
                    System.out.println("Invalid month number.");
                    scanner.close();
                    return;
                }
            }
            System.out.println("Number of days: " + days);
        }
    }
}