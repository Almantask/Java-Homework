package Advent;

import java.util.Arrays;
import java.util.List;

public class Day1 {

    public static void solve (List<String> input){

        System.out.println("The answer of Day1 part 1 is: " + part1(input));
        System.out.println();
        System.out.println("The answer of Day1 part 2 is: " + part2(input));
    }

    private static int part2 (List<String> input) {
        int [] ints = new int[input.size()];
        Arrays.setAll(ints, i -> Integer.parseInt(input.get(i)));
        int multiplying = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 1; j < ints.length; j++) {
                for (int k = 2; k < ints.length; k++) {
                    if (ints[i] + ints[j] + ints[k] == 2020) {
                        multiplying = ints[i] * ints[j] * ints[k];
                    }
                }
            }
        }
        return multiplying;
    }

    private static int part1 (List<String> input) {
        int [] ints = new int[input.size()];
        Arrays.setAll(ints, i -> Integer.parseInt(input.get(i)));
        int multiplying = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 1; j < ints.length; j++) {
                    if (ints[i] + ints[j] == 2020) {
                        multiplying = ints[i] * ints[j];
                    }
                }
        }
        return multiplying;
    }

}