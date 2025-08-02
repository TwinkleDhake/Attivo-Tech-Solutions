/* Q3. Create an abstract class Calculator with:
An abstract method calculate(int a, int b) for addition.
An abstract method calculate(String a, String b) for concatenating two strings.
Implement a concrete class AdvancedCalculator that overrides these methods.
Test both methods in the main method by creating an object of AdvancedCalculator. */

abstract class Calculator {
    public abstract int calculate(int a, int b);
    public abstract String calculate(String a, String b);
}
class AdvancedCalculator extends Calculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
    @Override
    public String calculate(String a, String b) {
        return a + b;
    }
}
public class CombinationCalculator {
    public static void main(String[] args) {
        AdvancedCalculator calc = new AdvancedCalculator();
        int sum = calc.calculate(10, 20);
        System.out.println("Sum: " + sum);
        String combined = calc.calculate("Hello, ", "World!");
        System.out.println("Concatenated String: " + combined);
    }
}