package Advent;

import java.util.*;

public class Day7 {

    public static void solve(List<String> input) {
        String key = "shiny gold ";

        System.out.println("Answer of Day7 part 1: " + countColors(input, key));
        System.out.println();
        System.out.println("Answer of Day7 part 2: " + countBags(input, key));

    }

    private static int countBags(List<String> input, String key) {
        List<List<Object>> containedBags = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(key);
        containedBags.add(list);
        int sum = 0;
        while (containedBags.size() > 0) {
            List<List<Object>> numbersAndColors = new ArrayList<>(containedBags);
            for (List<Object> o : numbersAndColors) {
                int number = (int) o.get(0);
                String color = (String) o.get(1);
                String row = findNeededRow(input, color);
                String[] contains = getContainedBag(row).split(", ");
                for (String s : contains) {
                    if (s.contains("no other bags")) {
                        continue;
                    }
                    int numberOfBags = getNumberOfBags(s) * number;
                    sum += numberOfBags;
                    List<Object> numberAndColor = new ArrayList<>();
                    numberAndColor.add(numberOfBags);
                    numberAndColor.add(getNameOfColor(s));
                    containedBags.add(numberAndColor);
                }
                containedBags.remove(o);
            }
        }
        return sum;
    }

    private static String getNameOfColor(String string) {
        String nameHalf1 = Arrays.asList(string.split(" ")).get(1);
        String nameHalf2 = Arrays.asList(string.split(" ")).get(2);
        return nameHalf1 + " " + nameHalf2;
    }

    private static int getNumberOfBags(String string) {
        return Integer.parseInt(Arrays.asList(string.split(" ")).get(0));
    }

    private static String findNeededRow(List<String> input, String key) {
        String neededRow = "";
        for (String s : input) {
            if (!getColorOfMainBag(s).contains(key)) {
                continue;
            }
            neededRow = s;
        }
        return neededRow;
    }

    private static int countColors(List<String> strings, String color) {
        List<String> bagsForTesting = new ArrayList<>(strings);
        List<String> matchesColors = new ArrayList<>(Collections.singleton(color));
        int sum = 0;
        while (matchesColors.size() > 0) {
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
