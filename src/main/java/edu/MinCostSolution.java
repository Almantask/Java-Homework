package edu;

public class MinCostSolution {

    public static final char INVALID = '-';

    public static int solve(String key, int[] numbers ) {
        if (numbers == null || key == null || key.isEmpty() || numbers.length != key.length() ) {
            return INVALID;
        }
        int trackedNumbers = numbers[0];
        int maxCost = numbers[0];
        for (int i = 1; i < key.length(); ++i) {
            if (key.charAt(i) != key.charAt(i - 1)) {
                trackedNumbers -= maxCost;
                maxCost = 0;
            }
            trackedNumbers += numbers[i];
            maxCost = Math.max(maxCost, numbers[i]);
        }
        return trackedNumbers - maxCost;
    }
}
