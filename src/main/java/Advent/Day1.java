package Advent;

import java.util.Arrays;
import java.util.List;

public class Day1 {
    public static int solveDay1(List input) {

        int [] ints = new int[input.size()];
        Arrays.setAll(ints, i -> Integer.parseInt(input.get(i).toString()));

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
}