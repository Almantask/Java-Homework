package ChristmasShopping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShoppingBag {

    private final LinkedList<Item> items;

    public ShoppingBag() {
        this.items = new LinkedList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Item item : this.items) {
            sum += item.getPrice();
        }

        return sum;
//        return sum;
//        this.items.stream()
//                .map(item -> item.getPrice())
//                .reduce(0d, (sum, next) -> sum+next

        // Stream is a generic data collection.
        // Every collection can be converted to stream.
        // Stream is not used to make changes to the existing collection (not for adding, not for removing)
        // Stream is used for filtering & processing.
//        return this.items.stream()
//                // get all items which start with letter A
//                .filter(item -> item.getName().startsWith("A"))
//                // get their prices
//                .mapToDouble(Item::getPrice)
//                // get only prices more than 10
//                .filter(price -> price > 10)
//                // sum all prices
//                .sum();

//        // The same as above
//        double sum = 0;
//        for (Item item : this.items) {
//            if(item.getName().startsWith("A") &&
//                    item.getPrice() > 10){
//                sum += item.getPrice();
//            }
//        }
//
//        // Function as an argument.
//        // Lambda expression is function as an argument
//        // Class::function
//        items.stream().forEach(System.out::println);
//        items.stream().forEach(item -> System.out.println(item));
//        items.stream().forEach(ShoppingBag::print);
//
//        // the same as above
//        for (Item item : items) {
//            System.out.println(item);
//        }
    }

    private static void print(Item item){
        System.out.println(item);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : this.items) {
            stringBuilder.append("Item: ").append(item.getName()).append("\n");
            stringBuilder.append("Price: ").append(item.getPrice()).append("\n");
            stringBuilder.append("************************************" + "\n");
        }
        return stringBuilder.toString();
    }

    public int getItems() {
        return items.size();
    }


}
