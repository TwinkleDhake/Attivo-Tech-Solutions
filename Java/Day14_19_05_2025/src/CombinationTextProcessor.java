/* Q6. Write a class TextProcessor with a method processText(String text) that:
Reverses the string.
Extend TextProcessor with a class AdvancedTextProcessor that:
Overrides processText(String text) to remove vowels from the string. */
class TextProcessor {
    public String processText(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
class AdvancedTextProcessor extends TextProcessor {
    @Override
    public String processText(String text) {
        return text.replaceAll("(?i)[aeiou]", "");
    }
}
public class CombinationTextProcessor {
    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor();
        System.out.println("Reversed: " + tp.processText("Hello World"));
        AdvancedTextProcessor atp = new AdvancedTextProcessor();
        System.out.println("Without vowels: " + atp.processText("Hello World"));
    }
}