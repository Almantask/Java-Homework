package main.java;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner input = new Scanner(System.in);
        System.out.println("Calculate: ");
        calculator.calculate(input.next());
    }


}
