package main.java;

import Advent.Day6;
import Advent.Input;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        String path = "C:\\Users\\Augis\\Desktop\\JAVA\\Advent Input\\Day6.txt";
        List input = Input.readFromFile(path);

        System.out.println(Day6.solveDay6_2(input));
        }
    }
