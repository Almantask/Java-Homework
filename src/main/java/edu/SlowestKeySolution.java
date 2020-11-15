package edu;

public class SlowestKeySolution {

    public static final char INVALID = '-';

    public static char solve(int[] releaseTimes, String keysPressed) {
        if (releaseTimes != null && releaseTimes.length != 0 &&
                keysPressed != null && !keysPressed.trim().isEmpty() &&
                releaseTimes.length == keysPressed.length()) {

            int[] pressedTimes = new int[releaseTimes.length];
            pressedTimes[0] = releaseTimes[0];
            for (int i = 1; i < pressedTimes.length; i++) {
                pressedTimes[i] = releaseTimes[i] - releaseTimes[i - 1];
            }

            char[] keysArray = keysPressed.toCharArray();
            char slowestKey = keysArray[0];
            int time = releaseTimes[0];

            for (int i = 0; i < pressedTimes.length - 1; i++) {
                if (time <= pressedTimes[i + 1]) {
                    if (time == pressedTimes[i + 1] && slowestKey >= keysArray[i + 1]) {
                        slowestKey = slowestKey;
                    } else
                        slowestKey = keysArray[i + 1];
                    time = pressedTimes[i + 1];
                }
            }
            return slowestKey;
        }
        return INVALID;
    }
}


