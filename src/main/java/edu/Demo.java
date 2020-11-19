package edu;

public class Demo {
    public static void main(String[] args) {
        int[] releaseTimes = {1, 2, 3, 10, 11};
        String keysPressed = "lkwen";
        char slowestKey = SlowestKeySolution.solve(releaseTimes, keysPressed);
        System.out.println(slowestKey);
    }
}
