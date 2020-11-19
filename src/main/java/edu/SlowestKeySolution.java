package edu;

import java.util.Arrays;

public class SlowestKeySolution {
    public static final char INVALID = '-';


    //    String keysPressed = "asdagrehhg";
//    int[] releaseTimes = new int[] { 1, 3, 4, 5, 8, 9, 10, 13, 14, 17};
//        SlowestKeySolution.solve(releaseTimes, keysPressed);
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
        System.out.println(Arrays.toString(ch) + "1)");
        int[] durations = countDurations(releaseTimes);
        System.out.println(Arrays.toString(durations));
        ch = order(durations, ch);
        System.out.println(Arrays.toString(ch) + "2)");
        System.out.println(Arrays.toString(durations) + "3)");
        System.out.println((int) ch[0]);
        answer = orderLetters(durations, ch);
        System.out.println((int) ch[0]);
        System.out.println(answer);
        return answer;
    }


    public static char[] createChar(String keysPressed) {
        char[] ch = new char[keysPressed.length()];
        for (int i = 0; i < keysPressed.length(); i++) {
            ch[i] = keysPressed.charAt(i);
        }
        return ch;
    }

//                System.out.println(ch);
//        int  b = (int) ch[0];

    public static int[] countDurations(int[] releaseTimes) {
        int[] durations = new int[releaseTimes.length];
        durations[0] = releaseTimes[0];
        System.out.println(Arrays.toString(durations));
        for (int i = 1; i < releaseTimes.length; i++) {
            int releaseTimesDuration = releaseTimes[i] - releaseTimes[i - 1];
            durations[i] = releaseTimesDuration;
        }
        return durations;
    }

    //                System.out.println(Arrays.toString(durations));
    public static char[] order(int[] durations, char[] ch) {
        int tempInt;
        char tempChar;
        for (int i = 0; i < durations.length; i++) {
            for (int j = i + 1; j < durations.length; j++) {
                if (durations[i] < durations[j]) {      //swap elements if not in order
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
        System.out.println(ch.length);
        if (ch.length == 1) {
            return ch[0];
        } else if (ch.length == 2 && !(durations[0] == (durations[1]))) {
            return ch[0];
        } else if (ch.length == 2) {
            int e = ch[0];
            System.out.println(e + "a");
            int c = ch[1];
            System.out.println(c + "b");
            if (e < c) {
                return ch[1];
            }
        } else {
            for (int l = 0; durations[l] == max; l++) {
                for (int k = 1; durations[k] == max; k++) {
                    int e = ch[l];
                    System.out.println(ch[l]);
                    int c = ch[k];
                    System.out.println(ch[k]);
                    if (e < c) {
                        tempChar2 = ch[l];

                        ch[l] = ch[k];
                        ch[k] = tempChar2;
                    }
                }
            }
        }
        System.out.println(ch[0]);
        return ch[0];
    }
}







