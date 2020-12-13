package main.java;

import Advent.Day4;
import Advent.Day5;
import Advent.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        String path = "C:\\Users\\Augis\\Desktop\\JAVA\\Advent Input\\Day5.txt";
        List input = Input.readFromFile(path);

        System.out.println(Day5.solveDay5(input));

        System.out.println(Day5.findYourSeat(input));

//        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);
//
//            // get mid index for splitting the input list into two
//            int midIndex = (inputList.size() - 1) / 2;
//
//            Map<Boolean, List<Integer>> map = inputList.stream()
//                    .collect(Collectors.groupingBy(s ->
//                            inputList.indexOf(s) > midIndex));
//            System.out.println(map);
//
//            List<List<Integer>> lists = new ArrayList<>(map.values());
//
//            System.out.println("The first sublist is " + lists.get(0));
//            System.out.println("The second sublist is " + lists.get(1));
        }
    }
