package edu;

import java.util.Arrays;

public class SlowestKeySolution {
    public static final char INVALID = '-';

    public static char solve(int[] releaseTimes, String keysPressed) {

        char[] ch = new char[keysPressed.length()];
        int[] durations = new int[releaseTimes.length - 1];
        for (int i = 1; i < ch.length; i++) {
            int releaseTimesDuration = releaseTimes[i] - releaseTimes[i - 1];
            durations[i - 1] = releaseTimesDuration;
        }
        System.out.println(Arrays.toString(durations));
        char[] chSorted = new char[ch.length];
        for (int k = 0; k < ch.length; k++) {
            for (int j = 1; j < ch.length; j++) {
                if (durations[k] > durations[1+j]){
                    chSorted[j] = ch[j];
                } else if (durations[k] == durations[1+j]) {
                    chSorted[j] = ch[j];
                }

            }

            Arrays.sort(durations);
//        System.out.printf("Modified arr[] : %s",
//                Arrays.toString(durations));


            //keyPressed =ith key pressed sebquense
            //releaseTimes[i] // was the time the ith key was released

            return INVALID;
        }

        return INVALID;
    }
}
