package edu;

public class Demo {
    public static void main(String[] args) {

        int[] releaseTimes = {12,23,36,46,62};
        String keysPressed = "spuda";

        char slowestKey = SlowestKeySolution.solve(releaseTimes,keysPressed);

        System.out.println(slowestKey);

    }
}