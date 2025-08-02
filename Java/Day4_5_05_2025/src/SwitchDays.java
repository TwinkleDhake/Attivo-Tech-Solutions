import java.util.Scanner;
public class SwitchDays {
    public static void main(String[] args) {
        //Create a Scanner object for user input
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a day number (1 - 7): ");
            int day = scanner.nextInt();
            //Use a switch statement to determine the day of the week
            //switch (day) {
                //case 1:
                    //System.out.println("Monday");
                    //break;
                //case 2:
                    //System.out.println("Tuesday");
                    //break;
                //case 3:
                    //System.out.println("Wednesday");
                    //break;
                //case 4:
                    //System.out.println("Thursday");
                    //break;
                //case 5:
                    //System.out.println("Friday");
                    //break;
                //case 6:
                    //System.out.println("Saturday");
                    //break;
                //case 7:
                    //System.out.println("Sunday");
                    //break;
                //default:
                    //System.out.println("Invalid day number! Please enter a number between 1 and 7");
            //}
            switch (day) {
                case 1 -> System.out.println("Monday");
                case 2 -> System.out.println("Tuesday");
                case 3 -> System.out.println("Wednesday");
                case 4 -> System.out.println("Thursday");
                case 5 -> System.out.println("Friday");
                case 6 -> System.out.println("Saturday");
                case 7 -> System.out.println("Sunday");
                default -> System.out.println("Invalid day number! Please enter a number between 1 and 7");
            }
        }
    }
}