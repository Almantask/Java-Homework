package edu;

public class SlowestKeySolution {
    public static final char INVALID = '-';

    public static char solve(int[] releaseTimes, String keysPressed) {
        return INVALID;
    }

    class Solution {
        public char slowestKey(int[] releaseTimes, String keysPressed) {
            char slowestKey = keysPressed.charAt(0);
            int slowestKeyDuration = releaseTimes[0];

            for (int i = 1; i < keysPressed.length(); i++) {
                char c = keysPressed.charAt(i);
                int duration = releaseTimes[i] - releaseTimes[i - 1];
                if (duration > slowestKeyDuration
                        || (duration == slowestKeyDuration && c > slowestKey)) {
                    slowestKey = c;
                    slowestKeyDuration = duration;
                }
            }
            return slowestKey;
        }
    }


}