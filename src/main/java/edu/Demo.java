package edu;

import ChristmasShopping.Items;
import ChristmasShopping.ShoppingBag;

public class Demo {
    public static void main(String[] args) {
        Items car = new Items("Car", 10);
        Items book = new Items("Book", 22);
        Items shoes = new Items("Shoes", 10);
        Items table = new Items("Table", 55);
        Items computer = new Items("Computer", 120);

        ShoppingBag shoppingBag = new ShoppingBag();
        shoppingBag.addItem(car);
        shoppingBag.addItem(book);
        shoppingBag.addItem(shoes);
        shoppingBag.addItem(table);
        shoppingBag.addItem(computer);

        System.out.println(shoppingBag.getTotalPrice());
    }
}
