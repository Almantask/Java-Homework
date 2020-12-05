package ChristmasShopping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShoppingBag {

    private final ArrayList<Item> items;

    public ShoppingBag() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getTotalPriceOfShoppingBag() {
        return this.items.stream().map(Item::getPrice).reduce(0d, Double::sum);
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
