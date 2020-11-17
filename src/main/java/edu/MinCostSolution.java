package edu;

import java.util.Arrays;

public class MinCostSolution {

    public static int solve(String s, int[] cost) {

        String[] stringElements = s.split("(?<=(.))(?!\\1)");

        int result = 0;
        int start = 0;
        for (String value : stringElements) {
            int end = start + value.length();
            result = result + costSum(cost, start, end);
            start = start + value.length();
        }
        return result;
    }

    private static int costSum(int[] cost, int start, int end) {
        int[] costArray = Arrays.copyOfRange(cost, start, end);
        int sum = Arrays.stream(costArray).sum();
        int max = Arrays.stream(costArray).max().getAsInt();
        return sum - max;
    }
}
