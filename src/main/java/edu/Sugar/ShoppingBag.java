package edu.Sugar;

import ChristmasShopping.Item;

public class ShoppingBag {
    private Item[] items;

    public ShoppingBag(Item ... items){
        this.items = items;
    }

    // Also ok, as long as vararg is last.
    public ShoppingBag(int a, Item ... items){
        this.items = items;
    }

    // Not ok, must be in the end.
//    public ShoppingBag(Item ... items, int ints){
//        this.items = items;
//    }

    // Not ok, only one varargs.
//    public ShoppingBag(Item ... items, int ... ints){
//        this.items = items;
//    }

    // the same as above
//    public ShoppingBag() {
//        this.items = new Item[0];
//    }
//
//    public ShoppingBag(Item item) {
//        this.items = new Item[1];
//        this.items[0] = item;
//    }
//
//    public ShoppingBag(Item[] items) {
//        this.items = items;
//    }
}
