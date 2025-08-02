// Q6. Write a method named countVowels that takes a string and returns the number of vowels in it.
public class CountVowels {
    public static int CountVowels(String input) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for(int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(input.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String text = "Hello, world!";
        System.out.println("Number of vowels: " + CountVowels(text));
    }
}