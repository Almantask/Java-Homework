package edu;

public class Main {
    public static void main(String[] args) {

        int[] cost = {9, 1, 2, 3, 4, 2, 6};
        String s = "aabaaac";

        MinCostSolution solution = new MinCostSolution(s, cost);

        System.out.println("Result:");
        System.out.println(solution.solve());
        System.out.println(solution.getS());
        for (int number : solution.getCost()){
            System.out.print(number);
        }

    }
}
