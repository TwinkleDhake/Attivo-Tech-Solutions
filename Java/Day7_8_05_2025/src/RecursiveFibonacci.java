// Q4. Write a recursive method named fibonacci to find the nth number in the Fibonacci sequence.
public class RecursiveFibonacci {
    public static int RecursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return RecursiveFibonacci(n - 1) + RecursiveFibonacci(n - 2);
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println("Fibonacci number at position " + n + " is " + RecursiveFibonacci(n));
    }
}