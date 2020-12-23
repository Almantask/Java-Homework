package Advent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day16 {

    public static void solve(List<String> input) {
        int solvePart1 = getInvalidValues(input).stream().mapToInt(Integer::intValue).sum();
        System.out.println();
        System.out.println("The answer of Day 16 part1 is: " + solvePart1);

        List<Long> row = valuesByRowFromYourTicket(input, "departure");
        long answer2 = row.stream().reduce(1L, (a, b) -> a * b);
        System.out.println("The answer of Day 16 part2 is: " + answer2);

    }

    private static List<Long> valuesByRowFromYourTicket(List<String> input, String nameOfRow) {
        List<Long> values = new ArrayList<>();
        List<Integer> yourTicketsValue = yourTicketValue(input);
        List<String> namesOfRows = getNamesOfRows(input);
        HashMap<String, Integer> namesAndIndexes = findIndexesByRow(input);
        for (String s : namesOfRows) {
            if (s.contains(nameOfRow))
                values.add(Long.valueOf(yourTicketsValue.get(namesAndIndexes.get(s))));
        }
        return values;
    }

    private static HashMap<String, Integer> findIndexesByRow(List<String> input) {
        HashMap<String, Integer> nameAndIndex = new HashMap<>();
        List<String> nameOfRow = getNamesOfRows(input);
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < getValidTickets(input).get(0).split(",").length; i++)
            indexes.add(i);
        while (nameOfRow.size() > 1) {
            List<String> list = new ArrayList<>(nameOfRow);
            List<Integer> index = new ArrayList<>(indexes);
            for (String s : list) {
                int sumPositions = getPositionsInRow(input, s, index).size();
                if (sumPositions == 1) {
                    nameAndIndex.put(s, getPositionsInRow(input, s, index).get(0));
                    nameOfRow.remove(s);
                    indexes.remove(getPositionsInRow(input, s, index).get(0));
                    System.out.println(nameAndIndex.size() + " : " + index);
                    break;
                }
            }
        }
        return nameAndIndex;
    }

    private static List<Integer> getPositionsInRow(List<String> input, String nameOfRow, List<Integer> indexes) {
        List<Integer> positions = new ArrayList<>();
        List<String> validTickets = getValidTickets(input);
        List<String> checkingRows = getCheckingRows(input, nameOfRow);
        int index = 0;
        while (index < indexes
                .size()) {
            boolean indexMatch = true;
            for (String s : validTickets) {
                int value = Integer.parseInt(s.split(",")[indexes.get(index)]);
                if (validation(value, checkingRows)) {
                    continue;
                }
                indexMatch = false;
                break;
            }
            if (indexMatch)
                positions.add(indexes.get(index));
            index += 1;
        }
        return positions;
    }

    private static List<String> getNamesOfRows(List<String> input) {
        List<String> nameOfRow = new ArrayList<>();
        for (String s : input) {
            if (s.isEmpty())
                break;
            nameOfRow.add(s.split(":")[0]);
        }
        return nameOfRow;
    }

    private static List<String> getCheckingRows(List<String> input, String nameOfRow) {
        List<String> checkingRows = new ArrayList<>();
        for (String s : input)
            if (s.contains(nameOfRow))
                checkingRows.add(s);
        return checkingRows;
    }

    private static List<String> getValidTickets(List<String> input) {
        List<Integer> invalidValue = getInvalidValues(input);
        List<String> validTickets = new ArrayList<>();
        int startIndex = findIndex(input, "nearby");
        for (int i = startIndex + 1; i < input.size(); i++) {
            boolean valid = true;
            for (int value : invalidValue)
                for (String j : input.get(i).split(","))
                    if (j.equals(Integer.toString(value))) {
                        valid = false;
                        break;
                    }
            if (valid)
                validTickets.add(input.get(i));
        }
        return validTickets;
    }

    private static List<Integer> yourTicketValue(List<String> input) {
        List<Integer> value = new ArrayList<>();
        int start = findIndex(input, "your ticket:");
        for (String s : input.get(start + 1).split(","))
            value.add(Integer.parseInt(s));
        return value;
    }

    private static List<Integer> getInvalidValues(List<String> input) {
        List<Integer> invalidValue = new ArrayList<>();
        List<Integer> nearbyTicketsValue = nearbyTicketsValue(input);
        for (int value : nearbyTicketsValue) {
            if (!validation(value, input))
                invalidValue.add(value);
        }
        return invalidValue;
    }

    private static boolean validation(int value, List<String> input) {
        List<int[]> ranges = getRanges(input);
        boolean valid = false;
        for (int[] range : ranges) {
            if (value < range[0] || value > range[1]) {
                continue;
            }
            valid = true;
            break;
        }
        return valid;
    }

    private static List<Integer> nearbyTicketsValue(List<String> input) {
        List<Integer> value = new ArrayList<>();
        int target = findIndex(input, "nearby tickets:");
        for (int i = target + 1; i < input.size(); i++) {
            String[] numbers = input.get(i).split(",");
            for (String s : numbers)
                value.add(Integer.parseInt(s));
        }
        return value;
    }

    private static List<int[]> getRanges(List<String> input) {
        List<int[]> ranges = new ArrayList<>();
        for (String s : input) {
            if (s.contains("your ticket:"))
                break;
            if (!s.isEmpty()) {
                String[] rangesString = (s.split(": ")[1]).split(" or ");
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
