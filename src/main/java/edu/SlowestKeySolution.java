package edu;

public class SlowestKeySolution {
    public static final char INVALID = '-';

    public static char solve(int[] releaseTimes, String keysPressed) {
        if (!isCorrectArguments(releaseTimes, keysPressed)) {
            return INVALID;
        }
        int[] durations = getDurations(releaseTimes);
        int slowestDuration = getSlowestDuration(durations);
        String slowestKeys = getSlowestKeys(keysPressed, durations, slowestDuration);
        return getSlowestKey(slowestKeys);
    }

    private static boolean isCorrectArguments(int[] releaseTimes, String keysPressed) {
        if (keysPressed == null || keysPressed.isEmpty()) {
            return false;
        }

        if (releaseTimes == null) {
            return false;
        }

        if (releaseTimes.length != keysPressed.length()) {
            return false;
        }

        return true;
    }

    private static int[] getDurations(int[] releaseTimes) {
        int[] durations = new int[releaseTimes.length];
        durations[0] = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            durations[i] = releaseTimes[i] - releaseTimes[i - 1];
        }
        return durations;
    }

    private static int getSlowestDuration(int[] durations) {
        int slowestDuration = 0;
        for (int i = 0; i < durations.length; i++) {
            if (durations[i] > slowestDuration) {
                slowestDuration = durations[i];
            }
        }
        return slowestDuration;
    }

    private static String getSlowestKeys(String keysPressed, int[] durations, int slowestDuration) {
        String slowestKeys = "";
        for (int i = 0; i < durations.length; i++) {
            if (durations[i] == slowestDuration) {
                slowestKeys += keysPressed.charAt(i);
            }
        }
        return slowestKeys;
    }

    private static char getSlowestKey(String slowestKeys) {
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
