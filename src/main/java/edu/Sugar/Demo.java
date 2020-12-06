package edu.Sugar;

import ChristmasShopping.Item;

public class Demo {
    public static void run(){
        ShoppingBag bag1 = new ShoppingBag();
        ShoppingBag bag2 = new ShoppingBag(new Item("1", 1));
        ShoppingBag bag3 = new ShoppingBag(new Item[]{new Item("1", 1)});
        ShoppingBag bag4 = new ShoppingBag(new Item("1", 1), new Item("2", 2));
    }


    // Syntax: type ... argumentName.
    public static void zeroToManyArguments1(Object ... objects)
    {
        for (Object o :
                objects) {
            System.out.println(o);
        }
    }

    // Keep in mind that varargs must be last.
    // You can have other arguments, but they must appear first.
    // Swapping the order of variables in this case will not compile.
    public static void zeroToManyArguments2(String a, Object ... objects)
    {
        for (Object o :
                objects) {
            System.out.println(o);
        }
    }

    public static void demoTernary(){
        Object o1 = null;
        Object o2 = null;

        // condition
        // ? what will happen if true
        // : what will happen if false
        int countNotNull =
                (o1 == null ? 0 : 1) +
                (o2 == null ? 0 : 1);

        //same as
        if(o1 != null){
            countNotNull++;
        }
        if(o2 != null){
            countNotNull++;
        }
    }

    public static void automaticallyDetermineType(){
        String text = "text";
    }
}
