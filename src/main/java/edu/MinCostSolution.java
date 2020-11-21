package edu;

public class MinCostSolution {
    public static int solve(String s, int[] cost){
        if(!validate(s, cost))
            return 0;

        return calculateCost(s, cost);

    }

    private static boolean validate(String s, int[] cost) {
        if(!s.matches("[a-z]+") || s.length() <= 1 || cost.length > Math.pow(10, 5) )
            return false;

        for(int i=0;i< cost.length;i++) {
            if(cost[i] < 1 || cost[i] > Math.pow(10, 4))
                return false;
        }
        return true;
    }

    private static boolean identicalLettersContaining(char[] extractedChars) {

        for(int i=0;i<extractedChars.length;i++) {
            if(extractedChars[i] == extractedChars[i+1])
                return true;
        }
        return false;
    }

    private static int calculateCost(String str, int[] costAt) {
        char[] extractedChars = str.toCharArray();
        int cost = 0;

        if(!identicalLettersContaining(extractedChars)) {
            return 0;
        }

        for(int i=0;i<extractedChars.length;i++) {
            if(extractedChars[i] == extractedChars[i+1]) {
                cost += Math.min(extractedChars[i], extractedChars[i+1]);
            }
        }
        return cost;
    }
}
