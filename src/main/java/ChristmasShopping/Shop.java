package ChristmasShopping;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String name;
    private ShoppingBag shoppingBag;

    public Shop(String name, ShoppingBag shoppingBag) {
        this.name = name;
        this.shoppingBag = shoppingBag;
    }

    public ShoppingBag getShoppingBag() {
        return shoppingBag;
    }

    public String getName() {
        return name;
    }
}
