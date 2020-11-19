package edu;

public class SlowestKeySolution {
    public static final char INVALID = '-';

    public static char solve(int[] releaseTimes, String keysPressed) {
        if (keysPressed == null || keysPressed.equals("")) {
            return INVALID;
        } else if (releaseTimes == null) {
            return INVALID;
        } else if (!(releaseTimes.length == keysPressed.length())) {
            return INVALID;
        }
        return play(releaseTimes, keysPressed);
    }

    public static char play(int[] releaseTimes, String keysPressed) {
        char answer;
        char[] ch = createChar(keysPressed);
        int[] durations = countDurations(releaseTimes);
        ch = order(durations, ch);
        answer = orderLetters(durations, ch);
        return answer;
    }


    public static char[] createChar(String keysPressed) {
        char[] ch = new char[keysPressed.length()];
        for (int i = 0; i < keysPressed.length(); i++) {
            ch[i] = keysPressed.charAt(i);
        }
        return ch;
    }


    public static int[] countDurations(int[] releaseTimes) {
        int[] durations = new int[releaseTimes.length];
        durations[0] = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int releaseTimesDuration = releaseTimes[i] - releaseTimes[i - 1];
            durations[i] = releaseTimesDuration;
        }
        return durations;
    }


    public static char[] order(int[] durations, char[] ch) {
        int tempInt;
        char tempChar;
        for (int i = 0; i < durations.length; i++) {
            for (int j = i + 1; j < durations.length; j++) {
                if (durations[i] < durations[j]) {
                    tempInt = durations[i];
                    tempChar = ch[i];
                    durations[i] = durations[j];
                    ch[i] = ch[j];
                    durations[j] = tempInt;
                    ch[j] = tempChar;
                }
            }
        }
        return ch;
    }


    public static char orderLetters(int[] durations, char[] ch) {
        int i;
        char tempChar2;
        int max = durations[0];
        for (i = 1; i < durations.length; i++)
            if (durations[i] > max)
                max = durations[i];
        if (ch.length == 1) {
            return ch[0];
        } else if (ch.length == 2 && !(durations[0] == (durations[1]))) {
            return ch[0];
        } else if (ch.length == 2) {
            int e = ch[0];
            int c = ch[1];
            if (e < c) {
                return ch[1];
            }
        } else {
            for (int l = 0; durations[l] == max; l++) {
                for (int k = 1; durations[k] == max; k++) {
                    int e = ch[l];
                    int c = ch[k];
                    if (e < c) {
                        tempChar2 = ch[l];

                        ch[l] = ch[k];
                        ch[k] = tempChar2;
                    }
                }
            }
        }
        return ch[0];
    }
}







