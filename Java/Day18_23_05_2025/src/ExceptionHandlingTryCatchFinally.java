// Q1. Write a program to demonstrate try, catch, and finally blocks.
public class ExceptionHandlingTryCatchFinally {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;
        try {
            // trying to divide by zero will throw an ArithmeticException
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // this handles the exception
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            // this will always execute, irrespective of an exception
            System.out.println("This is the finally block, always executes.");
        }
        System.out.println("Program continues after try-catch-finally.");
    }
}