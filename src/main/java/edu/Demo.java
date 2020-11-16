package edu;

public class Demo {

    public static void main(String[] args) {
        String keysPressed = "asdagrehhg";
        int[] releaseTimes = new int[] {1, 3, 4, 5, 8, 9, 10, 13, 14, 17};
        SlowestKeySolution.solve(releaseTimes, keysPressed);
    }
}