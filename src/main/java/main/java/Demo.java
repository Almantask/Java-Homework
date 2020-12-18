package main.java;

import Advent.Day11;
import Advent.Input;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        String path = "C:\\Users\\Augis\\Desktop\\JAVA\\Advent Input\\Day11.txt";
        List<String> input = Input.readFromFile(path);

        Day11.solve(input);

    }
}
