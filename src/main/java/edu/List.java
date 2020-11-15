package edu;

import java.util.Arrays;

public class List {
    public int[] list;

    public List(int[] list) {
        this.list = list;
    }
    public List() {}

    List add(int number){
        if(list == null)
            return new List(new int[]{number});

        int[] newList = new int[this.list.length+1];
        for(int i=0;i<list.length;i++) {
            newList[i] = list[i];
        }
        newList[list.length] = number;
        return new List(newList);
    }
    List removeAt(int index) {
        if(index >= list.length)
            return new List(list);

        int[] newList = new int[list.length-1];
        for(int i=0, add=0;i<list.length;i++) {
            if(i == index) {
                add = -1;
            } else {
                newList[i+add] = list[i];
            }
        }
        return new List(newList);
    }
    String getAll() {
        return Arrays.toString(list);
    }
    boolean any() {
        return list != null;
    }
}
