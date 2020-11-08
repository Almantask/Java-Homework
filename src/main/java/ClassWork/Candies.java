package ClassWork;

import java.util.Arrays;

public class Candies {




    public static int distributeCandies(int[] candies) {

        Arrays.sort(candies);
        int count = 0;
        for (int i = 1; i < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }
    private static int[] addNumber(int[] numbers, int n){
        int[] withExtra = new int[numbers.length+1];
        for (int i = 0; i < numbers.length; i++){
            withExtra[i] = numbers[i];
        }

        withExtra[withExtra.length-1] = n;

        return withExtra;
    }
}
