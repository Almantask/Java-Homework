package Advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day15 {
    public static void solve(List<String> input) {

        int[] givenNumbers = {0,3,1,6,7,5};
        int number1 = 2020;
        int number2 = 30000000;
        System.out.println();
        System.out.println("The answer of Day 15 part1 is: " + solvePart1(givenNumbers, number1));
        System.out.println();
        System.out.println("The answer of Day 15 part2 is: " + solvePart2(givenNumbers, number2));
    }

    private static int solvePart2(int[] input, int number) {
        int[] ints = new int[number];
        int[] numbers = new int[number];
        Arrays.fill(ints, -1);
        int turn2 = -1;
        for (int i : input) {
            turn2 += 1;
            numbers[turn2] = i;
            ints[i] = turn2;
        }
        int nextNumber2 = 0;
        while (turn2 + 1 < number) {
            turn2 += 1;
            int nextNo = nextNumber2;
            int secondNextNo = 0;
            if (ints[nextNo] != -1)
                secondNextNo = turn2 - ints[nextNo];
            ints[nextNo] = turn2;
            numbers[turn2] = nextNo;
            nextNumber2 = secondNextNo;
        }
        return numbers[number - 1];
    }

    private static int solvePart1(int[] input, int number) {
        List<Integer> spokenNumbers = new ArrayList<>();
        for (int s : input)
            spokenNumbers.add(s);
        spokenNumbers.add(0);
        int turn = spokenNumbers.size();
        while (turn < number) {
            int nextNumber = 0;
            for (int i = turn - 2; i >= 0; i--) {
                int lastNumber = spokenNumbers.get(turn - 1);
                if (lastNumber == spokenNumbers.get(i)) {
                    nextNumber = (turn - 1 - i);
                    break;
                }
            }
            spokenNumbers.add(nextNumber);
            turn = spokenNumbers.size();
        }
        return spokenNumbers.get(number - 1);
    }
}
