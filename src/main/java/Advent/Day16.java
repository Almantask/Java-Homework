package Advent;

import java.util.ArrayList;
import java.util.List;

public class Day16 {

//    public static void main(String[] args) {
//        String path = "C:\\Users\\Augis\\Desktop\\JAVA\\Advent Input\\Test.txt";
//        List<String> input = Input.readFromFile(path);
//
//        Day16.solve(input);
//    }

    public static void solve(List<String> input) {

        System.out.println();
        System.out.println("The answer of Day 16 part1 is: " + solvePart1(input));

    }

    private static int solvePart1(List<String> input) {
        List<Integer> invalidTickets = new ArrayList<>();
        List<Integer> nearbyTickets = nearbyTickets(input);
        for (int nearbyTicket : nearbyTickets) {
            if (!validation(nearbyTicket, input))
                invalidTickets.add(nearbyTicket);
        }
        return invalidTickets.stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean validation(int ticket, List<String> input) {
        List<int[]> ranges = getRanges(input);
        List<Integer> yourTickets = yourTickets(input);
        boolean valid = false;
        for (int[] range : ranges)
            if (ticket >= range[0] && ticket <= range[1]) {
                valid = true;
                break;
            }
        if (!valid)
            for (int yourTicket : yourTickets)
                if (ticket == yourTicket) {
                    valid = true;
                    break;
                }
        return valid;
    }

    private static List<Integer> yourTickets(List<String> input) {
        List<Integer> yourTickets = new ArrayList<>();
        int start = findIndex(input, "your ticket:");
        int end = findIndex(input, "nearby tickets");
        for (int i = start + 1; i < end; i++) {
            if (input.get(i) != null && !input.get(i).isEmpty()) {
                String[] numbers = input.get(i).split(",");
                for (String s : numbers)
                    yourTickets.add(Integer.parseInt(s));
            }
        }
        return yourTickets;
    }

    private static List<Integer> nearbyTickets(List<String> input) {
        List<Integer> nearbyTickets = new ArrayList<>();
        int target = findIndex(input, "nearby tickets:");
        for (int i = target + 1; i < input.size(); i++) {
            String[] numbers = input.get(i).split(",");
            for (String s : numbers)
                nearbyTickets.add(Integer.parseInt(s));
        }
        return nearbyTickets;
    }

    private static List<int[]> getRanges(List<String> input) {
        List<int[]> ranges = new ArrayList<>();
        int end = findIndex(input, "your ticket:");
        for (int i = 0; i < end; i++) {
            if (input.get(i) != null && !input.get(i).isEmpty()) {
                String[] rangesString = (input.get(i).split(": ")[1]).split(" or ");
                for (String range : rangesString) {
                    int[] r = {Integer.parseInt(range.split("-")[0]),
                            Integer.parseInt(range.split("-")[1])};
                    ranges.add(r);
                }
            }
        }
        return ranges;
    }

    private static int findIndex(List<String> input, String findingText) {
        int index = 0;
        for (int i = 0; i < input.size(); i++)
            if (input.get(i).contains(findingText)) {
                index = i;
                break;
            }
        return index;
    }

}
