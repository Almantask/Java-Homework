package Advent;

import java.util.*;

public class Day7 {

    public static void solve(List<String> input){
        String key = "shiny gold ";

        System.out.println("Answer of Day7 part 1: " + countColors(input, key));
    }

    private static int countColors (List<String> strings, String color){
        List<String> bagsForTesting = new ArrayList<>(strings);
        List<String> matchesColors = new ArrayList<>(Collections.singleton(color));
        int sum = 0;
        while (matchesColors.size()>0) {
            List<String> matches = new ArrayList<>(matchesColors);
            for (String s : matches) {
                List<String> testing = new ArrayList<>(bagsForTesting);
                for (String o : testing) {
                    if (!getContainedBag(o).contains(s)) {
                        continue;
                    }
                    bagsForTesting.remove(o);
                    matchesColors.add(getColorOfMainBag(o));
                    sum += 1;
                }
                matchesColors.remove(s);
            }
        }
        return sum;
    }

    private static String getContainedBag(Object o) {
        return Arrays.asList(o.toString().split(" contain ")).get(1);
    }

    private static String getColorOfMainBag(Object o) {
        return Arrays.asList(o.toString().split(" contain ")).get(0).replace("bags", "");
    }
}
