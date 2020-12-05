package ChristmasShopping;

import java.util.ArrayList;

public class ShoppingBag {

    private ArrayList<Items> items;

    public ShoppingBag() {
        this.items = new ArrayList<Items>();
    }

    public boolean addItem (Items items) {
        this.items.add(items);
        return true;
    }

    public int getTotalPrice () {
        int sum = 0;
        for (int i = 0; i <this.items.size(); i++) {
            sum += this.items.get(i).getPrice();
        }
        return sum;
    }

    public void printAllItems () {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println("Item: " + this.items.get(i).getName());
            System.out.println("Price: " + this.items.get(i).getPrice());
            System.out.println("************************************");
        }
    }

    public ArrayList<Items> getItems() {
        return items;
    }


}
