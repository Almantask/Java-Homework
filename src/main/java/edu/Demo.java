package edu;

import ChristmasShopping.Item;
import ChristmasShopping.Shop;
import ChristmasShopping.ShoppingBag;
import ChristmasShopping.ShoppingList;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Item car = new Item("Car", 10);
        Item book = new Item("Book", 22);
        Item shoes = new Item("Shoes", 10);
        Item table = new Item("Table", 55);
        Item computer = new Item("Computer", 120);

        ShoppingBag shoppingBag = new ShoppingBag();
        shoppingBag.addItem(car);
        shoppingBag.addItem(book);
        shoppingBag.addItem(shoes);
        shoppingBag.addItem(table);
        shoppingBag.addItem(computer);

        Item car1 = new Item("Car", 10);
        Item book1 = new Item("Book", 22);
        Item shoes1 = new Item("Shoes", 10);
        Item table1 = new Item("Table", 55);
        Item computer1 = new Item("Computer", 120);

        ShoppingBag shoppingBag1 = new ShoppingBag();
        shoppingBag1.addItem(car1);
        shoppingBag1.addItem(book1);
        shoppingBag1.addItem(shoes1);
        shoppingBag1.addItem(table1);
        shoppingBag1.addItem(computer1);

        Shop shop = new Shop("Edvinas Shop", shoppingBag);
        Shop shop1 = new Shop("Edvinas1 Shop", shoppingBag1);

        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addShop(shop);
        shoppingList.addShop(shop1);

        System.out.println(shoppingList.returnFullPrice());


    }
}
