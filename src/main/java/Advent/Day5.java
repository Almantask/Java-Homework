package Advent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 {
    public static int solveDay5(List<String> input) {
        List<Integer> listOfID = new ArrayList<>();
        for (Object o : input) {
            listOfID.add(findSeatID(o));
        }
        System.out.println(listOfID);
        return Collections.max(listOfID);
    }

    public static int findYourSeat (List<String> input){
        List<Integer> listOfID = new ArrayList<>();
        for (Object o : input) {
            listOfID.add(findSeatID(o));
        }
        Collections.sort(listOfID);
        int yourSeatID = 0;
        for(int i=1; i<listOfID.size(); i++){
            if(listOfID.get(i) - listOfID.get(i-1) == 1){
                continue;
            }
            yourSeatID = (listOfID.get(i) + listOfID.get(i-1)) / 2;
        }
        return yourSeatID;
    }

    private static int findSeatID(Object o) {
        int[] minMaxRow = {0, 127};
        int[] minMaxCol = {0, 7};
        char[] seatsCode = o.toString().toCharArray();
        for (char c : seatsCode) {
            if (c == 'F' || c == 'B') {
                changeLimits(c, minMaxRow);
            } else if (c == 'L' || c == 'R') {
                changeLimits(c, minMaxCol);
            }
        }
        return minMaxRow[1] * 8 + minMaxCol[1];
    }

    private static void changeLimits(char ch, int[] minMax) {
        switch (ch) {
            case 'F':
            case 'L':
                minMax[1] -= ((minMax[1] - minMax[0]) + 1) / 2;
                break;
            case 'B':
            case 'R':
                minMax[0] += ((minMax[1] - minMax[0]) + 1) / 2;
                break;
        }
    }
}
