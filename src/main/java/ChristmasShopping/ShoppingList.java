package ChristmasShopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<Shop> shops;

    public ShoppingList() {
        this.shops = new ArrayList<>();
    }

    public void addShop(Shop shop) {
        shops.add(shop);
    }

    public double returnFullPrice() {
        return shops.stream()
                .mapToDouble(shop -> shop.getShoppingBag().getTotalPriceOfShoppingBag())
                .sum();
    }
}
