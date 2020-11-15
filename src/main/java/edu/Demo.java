package edu;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        List firstList = new List();
        List secondList = new List(new int[]{6,5,4,3});

        System.out.printf("First list is not null: %b\n",firstList.any());
        System.out.printf("Second list is not null: %b\n",secondList.any());

        List firstListAdded = firstList.add(6);
        List secondListRemoved = secondList.removeAt(2);
        System.out.printf("First list changed: %s\n", firstListAdded.getAll());
        System.out.printf("Second list: %s\n",secondListRemoved.getAll());
    }
}
