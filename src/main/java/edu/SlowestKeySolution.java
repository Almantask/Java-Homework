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
        }  else if (releaseTimes == null) {
            return INVALID;
        } else if (!(releaseTimes.length == keysPressed.length())) {
            return INVALID;
        }
        char[] ch = new char[keysPressed.length()];
                for (int i = 0; i < keysPressed.length(); i++) {
                    ch[i] = keysPressed.charAt(i);
                }
                System.out.println(ch);
        int  b = (int) ch[0];
        char tempChar2 = '0';
        System.out.println(b);
                int[] durations = new int[releaseTimes.length];
                int tempInt = 0;
                char tempChar = 'a';
                durations[0] = releaseTimes[0];
                System.out.println(Arrays.toString(durations));
                for (int i = 1; i < releaseTimes.length; i++) {
                    int releaseTimesDuration = releaseTimes[i] - releaseTimes[i - 1];
                    durations[i] = releaseTimesDuration;
                }
                System.out.println(Arrays.toString(durations));

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
        System.out.println(ch);
        for (int l = 0; (durations[l] == (durations[l+1])); l++) {
                for (int k = 1; (durations[k] == (durations[k+1])); k++) {
                        int e = (int) ch[l];
                    System.out.println(e);
                        int c = (int) ch[k];
                    System.out.println(c);
                        if (e < c) {
                            tempChar2 = ch[l];
                            ch[l] = ch[k];
                            ch[k] = tempChar2;
                        }
                    }
                }


                System.out.println(Arrays.toString(durations));
                System.out.print(ch);

                return ch[0];
            }
        }





