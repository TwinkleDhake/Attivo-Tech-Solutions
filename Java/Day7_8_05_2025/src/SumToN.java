// Q5. Write a method named sumToN that calculates the sum of all numbers from 1 to n using recursion.
public class SumToN {
    public static int sumToN(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumToN(n - 1);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int result = sumToN(n);
        System.out.println("Sum from 1 to " + n + " is: " + result);
    }
}