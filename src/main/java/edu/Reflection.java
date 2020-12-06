package edu;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class Reflection {
    public static void demo() throws NoSuchFieldException, IllegalAccessException {
        // Reflection is a way of reading all class metadata (even if it's private)
        Item item = new Item("1", "11", 111d);

        // UGLY, DIRTY, AVOID
        // Sometimes, we are cornered to the wall.
        // We need a value of a private field.
        // But we don't have access to it.
        // With reflection, we have all the access there can possible be.
        // So with reflection- it's not a problem.

        // With reflection we can create weakly typed programs in java.

        // Attributes.
        Class<Item> type = Item.class;
        Field field = type.getDeclaredField("price");
        field.setAccessible(true);
        double price1 = (double)field.get(item);
        System.out.println(String.format("price = %s", price1));

        double price2 = item.getPrice();
        System.out.println(String.format("price = %s", price2));
    }
}
