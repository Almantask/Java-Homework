package main.java;

import Advent.Day7;
import Advent.Input;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        String path = "C:\\Users\\Augis\\Desktop\\JAVA\\Advent Input\\Day7.txt";
        List input = Input.readFromFile(path);

        Day7.solve(input);

    }
}
