/* Q8. Write a class ShoppingCart with a private field items (List<String>). Provide methods:
addItem(String item)
removeItem(String item)
getItems()
Ensure that the items list cannot be modified directly outside the class. 
Demonstrate this in the main method by trying to modify the list directly. */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class ShoppingCart {
    private final List<String> items;
    public ShoppingCart() {
        items = new ArrayList<>();
    }
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " added to cart.");
    }
    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println(item + " removed from cart.");
        } else {
            System.out.println(item + " not found in cart.");
        }
    }
    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }
}
public class EncapsulationShoppingCart {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop");
        cart.addItem("Mouse");
        cart.addItem("Keyboard");

        System.out.println("Items in cart: " + cart.getItems());
        final List<String> items = cart.getItems();
        try {
            items.add("Monitor");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify items list directly! Encapsulation protects the list.");
        }
        cart.removeItem("Mouse");
        System.out.println("Items in cart after removal: " + cart.getItems());
    }
}