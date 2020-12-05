package edu;

import ChristmasShopping.Item;
import ChristmasShopping.ShoppingBag;

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

        System.out.println(shoppingBag);
        shoppingBag.getTotalPrice();


    }
}
