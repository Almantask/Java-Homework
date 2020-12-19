package main.java;

import Advent.Day13;
import Advent.Input;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        String path = "C:\\Users\\Augis\\Desktop\\JAVA\\Advent Input\\Day13.txt";
        List<String> input = Input.readFromFile(path);

        Day13.solve(input);

    }
}
