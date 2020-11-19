package edu;

public class SlowestKeySolution {
    public static final char INVALID = '-';

    public static char solve(int[] releaseTimes, String keysPressed) {
        if (!initialConditionIsTrue(releaseTimes, keysPressed)) {
            return INVALID;
        }
        int[] pressTime = getPressTime(releaseTimes);
        int maxTime = getMaxTime(pressTime);
        String slowestKeys = getSlowestKeys(keysPressed, pressTime, maxTime);
        return getSlowestKey(slowestKeys);
    }

    public static boolean initialConditionIsTrue(int[] releaseTimes, String keysPressed) {
        if (releaseTimes == null ||
            keysPressed == null ||
            releaseTimes.length == 0 ||
            keysPressed.trim().isEmpty() ||
            (releaseTimes.length != keysPressed.length())) {
            return false;
        }
        return true;
    }

    public static int[] getPressTime(int[] releaseTimes) {
        int[] pressTime = new int[releaseTimes.length];
        pressTime[0] = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            pressTime[i] = releaseTimes[i] - releaseTimes[i - 1];
        }
        return pressTime;
    }

    public static int getMaxTime(int[] pressTime) {
        int maxTime = 0;
        for (int i = 0; i < pressTime.length; i++) {
            if (pressTime[i] > maxTime) {
                maxTime = pressTime[i];
            }
        }
        return maxTime;
    }

    public static String getSlowestKeys(String keysPressed, int[] pressTime, int maxTime) {
        keysPressed = keysPressed.toLowerCase();
        String slowestKeys = "";
        for (int i = 0; i < pressTime.length; i++) {
            if (pressTime[i] == maxTime) {
                slowestKeys += keysPressed.charAt(i);
            }
        }
        return slowestKeys;
    }

    public static char getSlowestKey(String slowestKeys) {
        char[] slowestKeyArray = slowestKeys.toCharArray();
        char slowestKey = 'a';
        for (int i = 0; i < slowestKeyArray.length; i++) {
            if (slowestKeyArray[i] > slowestKey) {
                slowestKey = slowestKeyArray[i];
            }
        }
        return slowestKey;
    }
}