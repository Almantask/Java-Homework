package main.java;

import Advent.Day7;
import Advent.Day8;
import Advent.Input;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        String path = "C:\\Users\\Augis\\Desktop\\JAVA\\Advent Input\\Day8.txt";
        List input = Input.readFromFile(path);

        Day8.solve(input);

    }
}
