package main.java;


import Advent.Day3;
import Advent.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List input = Input.addData();

//        System.out.println(Advent.Day2.solveDay2(input));
//        System.out.println(Advent.Day2.solveDay2_2(input));

//        System.out.println(Day3.solveDay3_1(input));
//        System.out.print(input);
        System.out.println(Day3.solveDay3_1(input));
//        System.out.println(Arrays.stream(Day3.test(input)).toArray());
        System.out.println(Day3.treesList(input,1,1));
        System.out.println(Day3.treesList(input,3,1));
        System.out.println(Day3.treesList(input,5,1));
        System.out.println(Day3.treesList(input,7,1));
        System.out.println(Day3.treesList(input,1,2));
    }
}
