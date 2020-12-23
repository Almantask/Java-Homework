package Advent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {

    public static void solve(List<String> input) {

        System.out.println("Answer of Day9 part 1 is: " + findFirstNotMatchedNumber(input));
        System.out.println();
        System.out.println("Answer of Day9 part 2 is: " + encryptedWeakness(input));
    }

    private static long encryptedWeakness (List<String> input) {
        List<Long> numbers = new ArrayList<>();
        long number = 0;
        long goal = findFirstNotMatchedNumber(input);
        int i = 0;
        int secondLoop = 0;
        while (true){
            numbers.add(Long.parseLong(input.get(i)));
            number += Long.parseLong(input.get(i));
            i += 1;
            if(number == goal) break;
            if(number > goal){
                i = secondLoop + 1;
                secondLoop += 1;
                number = 0;
                numbers.removeAll(numbers);
            }
        }
return Collections.max(numbers) + Collections.min(numbers);
    }

    private static long findFirstNotMatchedNumber(List<String> input) {
        List<Long> number = new ArrayList<>();
        for (int i = 25; i < input.size(); i++) {
            number.add(Long.parseLong(input.get(i)));
            for (int j = i - 25; j < i; j++)
                for (int k = i - 24; k < i - 1; k++)
                    if ((Long.parseLong(input.get(j)) != (Long.parseLong(input.get(k)))) &&
                            Long.parseLong(input.get(j)) + Long.parseLong(input.get(k))
                                    == Long.parseLong(input.get(i))) number.remove(Long.parseLong(input.get(i)));
        }
        return number.get(0);
    }
}
