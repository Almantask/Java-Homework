package edu;

public class SlowestKeySolution {
    public static final char INVALID = '-';

    public static char solve(int[] releaseTimes, String keysPressed) {
        if (!Validation(releaseTimes, keysPressed)) {
            return INVALID;
        }
        int[] durations = getDurations(releaseTimes);
        int longestDuration = getLongestDuration(durations);
        String slowestKeys = getSlowestKeys(keysPressed, durations, longestDuration);
        return biggestNumber(slowestKeys);
    }

    private static boolean Validation(int[] releaseTimes, String keysPressed) {
        // Step 1 keys pressed null or empty
        if (keysPressed == null || keysPressed.isEmpty()) {
            return false;
        }
        // Step 2 release times null check
        if (releaseTimes == null) {
            return false;
        }
        // Step 3 release times length comparison
        if (releaseTimes.length != keysPressed.length()) {
            return false;
        } else return true;
    }

    // Step 4 find durations for each key press
    private static int[] getDurations(int[] releaseTimes) {
        int[] durations = new int[releaseTimes.length];
        durations[0] = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            durations[i] = releaseTimes[i] - releaseTimes[i - 1];
        }
        return durations;
    }

    // Step 5 find largest number in durations array.
    private static int getLongestDuration(int[] durations) {
        int longestDuration = 0;
        for (int i = 0; i < durations.length; i++) {
            if (durations[i] > longestDuration) {
                longestDuration = durations[i];
            }
        }
        return longestDuration;
    }

    // Step 6 find which keys in keysPressed String has this
    // largest numbers (longest duration), store them in separate string;
    private static String getSlowestKeys(String keysPressed, int[] durations, int longestDuration) {
        String slowestKeys = "";
        for (int i = 0; i < durations.length; i++) {
            if (durations[i] == longestDuration) {
                slowestKeys += keysPressed.charAt(i);
            }
        }
        return slowestKeys;
    }

    // Step 7 Find which key (as the character) has the largest number according to ASCII;
    private static char biggestNumber(String slowestKeys) {
        char[] slowestKeysArray = slowestKeys.toCharArray();
        char slowestKey = 'a';
        for (int i = 0; i < slowestKeysArray.length; i++) {
            if (slowestKeysArray[i] > slowestKey) {
                slowestKey = slowestKeysArray[i];
            }
        }
        return slowestKey;
    }
}
