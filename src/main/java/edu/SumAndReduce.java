package edu;

import java.util.List;
import java.util.stream.Collectors;

public class SumAndReduce {
    public static int calculate(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, Integer::sum);

        // or
//        return numbers
//                .stream()
//                .collect(Collectors.summingInt(Integer::intValue));

        // or
//        return numbers
//                .stream()
//                .mapToInt(Integer::intValue)
//                .sum();
    }

//    public static int calculate(List<Integer> numbers) {
//        int total = 0;
//        for (int number : numbers) {
//            total += number;
//        }
//        return total;
//    }
}
