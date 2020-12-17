package Advent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    public static void solve(List<String> input) {

        System.out.println("Answer of Day10 part 1 is: " + countDifferences(input));
        System.out.println();
        System.out.println("Answer of Day10 part 2 is: " + countDistinctWays(input));
    }

    private static long countDistinctWays(List<String> input) {
        List<List<Integer>> numbers = getChangedList(input);
        long ways = 1;
        for (List<Integer> n : numbers)
            switch (n.size()) {
                case 5:
                    ways *= 7;
                    break;
                case 4:
                    ways *= 4;
                    break;
                case 3:
                    ways *= 2;
                    break;
            }
            return ways;
        }

    private static List<List<Integer>> getChangedList (List<String> input){
        List<Integer> numbers = input.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        numbers.add(0, 0);
        numbers.add(Collections.max(numbers)+3);
        List<List<Integer>> changedList = new ArrayList<>();
        List<Integer> numbersToArray = new ArrayList<>();
        if(numbers.get(1) - numbers.get(0) < 3 ){
            numbersToArray.add(numbers.get(0));
        }
        for(int i=1; i<numbers.size(); i++) {
            if (numbers.get(i) - numbers.get(i-1) < 3) {
                numbersToArray.add(numbers.get(i));
            }
            if(numbers.get(i) - numbers.get(i-1) == 3){
                changedList.add(numbersToArray);
                numbersToArray = new ArrayList<>();
                numbersToArray.add(numbers.get(i));
            }
        }
        return changedList;
    }

    private static int countDifferences(List<String> input) {
        List<Integer> numbers = input.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        numbers.add(0, 0);
        int differences1 = 0;
        int differences3 = 1;
        for (int i = 0; i < numbers.size() - 1; i++) {
            int difference = numbers.get(i + 1) - numbers.get(i);
            if (difference == 1)
                differences1 += 1;
            else if (difference == 3)
                differences3 += 1;
        }
        return differences1 * differences3;
    }
}
