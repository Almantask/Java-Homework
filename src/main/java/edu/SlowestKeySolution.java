package edu;

import java.util.ArrayList;

public class SlowestKeySolution {
    public static final char INVALID = '-';
    public static ArrayList<Character> uniqueKeysPressed = new ArrayList<>();

    public static char solve(int[] releaseTimes, String keysPressed) {
        uniqueKeysPressed.clear();


        if (releaseTimes == null || releaseTimes.length < 1 || keysPressed == null || keysPressed.matches("[^a-z]+") || releaseTimes.length != keysPressed.length())
            return INVALID;


        int[] durations = new int[releaseTimes.length];
        durations[0] = releaseTimes[0];
        for (int i=1; i<durations.length; i++) {
            durations[i] = releaseTimes[i]-releaseTimes[i-1];
        }

        int[] longestPressedChar = findDuplicates(durations, keysPressed);
        return uniqueKeysPressed.get(longestPressedChar[1]);

        //return longestPressedCharacter;
    }

    private static int[] findDuplicates(int[] durations, String keysPressed) {
        char[] keysPressedArr = new char[keysPressed.length()];
        keysPressedArr = keysPressed.toCharArray();

        for (int i=0; i<keysPressedArr.length;i++) {
            int k=0;
            for(int j=0;j<uniqueKeysPressed.size();j++) {
                if(uniqueKeysPressed.get(j) == keysPressedArr[i]) {
                    k++;
                }
            }
            if(k == 0) {
                uniqueKeysPressed.add(keysPressedArr[i]);
            }
        }

        int[] finalDurations = new int[uniqueKeysPressed.size()];

        if(keysPressedArr.length == uniqueKeysPressed.size()) {
            return getHighest(durations);
        }

        for(int j=0;j<keysPressedArr.length;j++) {
            for(int i=0;i<uniqueKeysPressed.size();i++) {
                if(uniqueKeysPressed.get(i) == keysPressedArr[j]) {
                    finalDurations[i] += durations[j];
                }

            }
        }
        return getHighest(finalDurations);
    }

    static int[] getHighest(int[] data) {
        int[] highestNumber = new int[2];
        for(int i=0;i<data.length;i++) {
            if(data[i] > highestNumber[0]) {
                highestNumber[0] = data[i];
                highestNumber[1] = i;
            }
        }
        return highestNumber;
    }
}
