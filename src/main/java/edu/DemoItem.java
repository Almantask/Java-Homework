package edu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DemoItem {
    public static void main(String[] args) throws IOException {
        demoUser();
    }
    private static void demoUser(){
        Item item4 = new Item("Samsung",750);
        itemRegister register1 = BuildItemRegister();
        //add Item
        //register1.add(item4);
        //remuve Item
        item4.clear();
        Item item5 = register1.get(450L);
        System.out.println(item5);
    }
    private static itemRegister BuildItemRegister() {
        Item item1 = new Item("Huawei", 550);
        Item item2 = new Item("Nokia", 450);
        Item item3 = new Item("Xiomi", 350);
        Item[]items = {item1,item2,item3};
        itemRegister register1 = new itemRegister(items);
        return register1;
    }
    private static String getPhone(int price){
        Map<Integer,String>gadget = new HashMap<>();
        gadget.put(150, "Siemens");
        gadget.put(200, "Ericson");
        String Phone = gadget.get(price);
        return Phone;
    }
}
