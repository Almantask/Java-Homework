package edu;

import java.util.HashMap;
import java.util.Map;

public class itemRegister {

        private Map<Long, Item> goods = new HashMap<>();


        public itemRegister(Item[]goods) {
            for (Item item:goods) {
                add(item);
            }
        }
    public void add (Item item){
        goods.put(item.getPrice(), item);
    }
    public Item get (Long price){
        return goods.get(price);
    }
}
