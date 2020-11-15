package edu;

public class Demo {

    public static void main(String[] args) {
        String keysPressed = "-asdagrehhg";
        int[] releaseTimes = new int[] {0, 1, 3, 4, 5, 8, 9, 10, 13, 14, 17};
        System.out.println("Hello!");
        SlowestKeySolution.solve(releaseTimes, keysPressed);
    }
}