package main.java;

import Advent.Day12;
import Advent.Input;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        String path = "C:\\Users\\Augis\\Desktop\\JAVA\\Advent Input\\Day12.txt";
        List<String> input = Input.readFromFile(path);

        Day12.solve(input);

    }
}
