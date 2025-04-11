
### **Problem Statement**
You are tasked to implement a small program in Java for a shopping cart system. The program should:
1. Add items to the cart with their name and price.
2. Display the total price of all items in the cart.
3. Apply a discount to the total price if the cart total exceeds a certain threshold.

#### **Requirements:**
1. Avoid hardcoding values like the discount percentage or threshold.
2. Ensure that the code for adding items and calculating totals is reusable.

---

### **Starter Code (Without DRY)**
Try to identify areas where the DRY principle is violated:

```java
public class ShoppingCart {
    public static void main(String[] args) {
        // Adding items
        System.out.println("Adding item: Apple, Price: $1.50");
        System.out.println("Adding item: Orange, Price: $2.00");
        
        double total = 1.50 + 2.00;

        // Applying discount if total > $10
        if (total > 10) {
            total = total - (total * 0.10); // Hardcoded discount
        }

        System.out.println("Total Price: $" + total);
    }
}
```

---

### **Your Task**
Refactor the code to follow the **DRY Principle**:
- Abstract the logic for adding items into a reusable method.
- Use constants for values like the discount percentage and threshold.
- Make the program dynamic (able to handle any number of items).

---

### **Hints**
1. Use a **method** to add items.
2. Use a **list** to store item prices.
3. Parameterize the discount logic to make it reusable.

### **Refactored/Answer Code**
```java
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    // Constants for discount logic
    private static final double DISCOUNT_THRESHOLD = 10.0; // Threshold for discount
    private static final double DISCOUNT_PERCENTAGE = 0.10; // 10% discount

    public static void main(String[] args) {
        // List to store item prices
        List<Double> cart = new ArrayList<>();

        // Adding items to the cart
        addItem(cart, "Apple", 1.50);
        addItem(cart, "Orange", 2.00);
        addItem(cart, "Grapes", 8.00);

        // Calculating total
        double total = calculateTotal(cart);

        // Applying discount
        double finalTotal = applyDiscount(total);

        // Displaying the total price
        System.out.println("Total Price after Discount (if applicable): $" + finalTotal);
    }

    // Method to add an item to the cart
    private static void addItem(List<Double> cart, String itemName, double price) {
        cart.add(price);
        System.out.println("Added item: " + itemName + ", Price: $" + price);
    }

    // Method to calculate the total price of items in the cart
    private static double calculateTotal(List<Double> cart) {
        double total = 0;
        for (double price : cart) {
            total += price;
        }
        return total;
    }

    // Method to apply discount if the total exceeds the threshold
    private static double applyDiscount(double total) {
        if (total > DISCOUNT_THRESHOLD) {
            total -= total * DISCOUNT_PERCENTAGE;
        }
        return total;
    }
}
```

---

### **Key Improvements**
1. **Reusability**:
    - Extracted the logic for adding items into the `addItem` method.
    - Created `calculateTotal` and `applyDiscount` methods to encapsulate specific logic.

2. **Avoided Hardcoding**:
    - Used constants for `DISCOUNT_THRESHOLD` and `DISCOUNT_PERCENTAGE` to make the code easier to maintain and adjust.

3. **Dynamic Behavior**:
    - Used a `List` to store items, allowing the program to handle any number of items without changes.

---

### **Output**
For the items added (`Apple: $1.50`, `Orange: $2.00`, `Grapes: $8.00`):
```
Added item: Apple, Price: $1.5
Added item: Orange, Price: $2.0
Added item: Grapes, Price: $8.0
Total Price after Discount (if applicable): $10.35
```
