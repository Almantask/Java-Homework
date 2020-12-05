package ChristmasShopping;

import java.util.ArrayList;

public class ShoppingBag {

    private ArrayList<Item> items;

    public ShoppingBag() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getTotalPrice() {
        double sum = 0;
        for (int i = 0; i < this.items.size(); i++) {
            sum += this.items.get(i).getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.items.size(); i++) {
            stringBuilder.append("Item: " + this.items.get(i).getName() + "\n");
            stringBuilder.append("Price: " + this.items.get(i).getPrice() + "\n");
            stringBuilder.append("************************************" + "\n");
        }
        return stringBuilder.toString();
    }

    public int getItems() {
        return items.size();
    }


}
