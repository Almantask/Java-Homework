package edu;

import java.util.ArrayList;

public class SlowestKeySolution {
    public static final char INVALID = '-';
    public static char longestPressedCharacter;

    public static char solve(int[] releaseTimes, String keysPressed) {



        if (releaseTimes == null || releaseTimes.length < 1 || !keysPressed.matches("[a-z]+") || releaseTimes.length != keysPressed.length())
            return INVALID;

        int[] durations = new int[releaseTimes.length];
        durations[0] = releaseTimes[0];
        for (int i=1; i<durations.length; i++) {
            durations[i] = releaseTimes[i]-releaseTimes[i-1];
        }
        ArrayList<Integer> duplicatingIndexes = findDuplications(durations);

        if(duplicatingIndexes.size() > 0) {
            longestPressedCharacter = keysPressed.charAt(duplicatingIndexes.get(duplicatingIndexes.size()-1));
        } else {
            for(int i=0;i<durations.length;i++){
                if(durations[i] == getHighest(durations))
                    longestPressedCharacter = keysPressed.charAt(i);
            }
        }
        return longestPressedCharacter;
    }
    private static ArrayList<Integer> findDuplications(int[] data) {
        ArrayList<Integer> duplicatingIndexes = new ArrayList<Integer>();
        int highestInteger = getHighest(data);
        for(int i=0;i<data.length;i++) {
            if(data[i] == highestInteger) {
                for(int j=i+1;j<data.length;j++) {
                    if(data[i] == data[j]) {
                        duplicatingIndexes.add(i);
                        duplicatingIndexes.add(j);
                    }
                }
            }
        }
        return duplicatingIndexes;
    }
    static int getHighest(int[] data) {
        int highestNumber = 0;
        for(int i=0;i<data.length;i++) {
            if(data[i] > highestNumber) {
                highestNumber = data[i];
            }
        }
        return highestNumber;
    }
}
