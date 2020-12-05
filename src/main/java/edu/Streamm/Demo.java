package edu.Streamm;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo {
    public static void run(){

    }

    private static void fromAnyManythingsToStream(){
        Integer[] numbers = {1,2,3,5};
        Stream<Integer> numbersStream = Arrays.stream(numbers);
    }

    private static void sumAllNumbes(Stream<Integer> numbers){
        // First way
        int sum = numbers.reduce(0, (a, b) -> a + b);
        // Second way
        sum = numbers.reduce(0, Integer::sum);
        // Third way
        sum = numbers
                .mapToInt(Integer::intValue)
                .sum();
        // and many more...
    }
}
