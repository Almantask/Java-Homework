package Advent;

import java.util.ArrayList;
import java.util.List;

public class Day11 {

    public static void solve(List<String> input) {

        System.out.println("The answer of Day 11 part 1 is : " + countAllOccupiedSeat(input));

    }

    private static int countAllOccupiedSeat(List<String> input) {
        List<String> map = getChangedMap(input);
        int seatNumber1 = 0;
        int seatNumber2 = 1;
        while (seatNumber1 != seatNumber2) {
            List<String> changedMap = new ArrayList<>(map);
            seatNumber1 = countOccupiedSeat(map);
            for (int i = 1; i < changedMap.size() - 1; i++) {
                char[] seats = changedMap.get(i).toCharArray();
                for (int j = 1; j < seats.length - 1; j++) {
                    if (checkIfNeedToChangeState(seats[j], countOccupiedAroundSeat(changedMap, i, j)))
                        seats[j] = changeSeatState(seats[j]);
                }
                map.set(i, String.valueOf(seats));
            }
            seatNumber2 = countOccupiedSeat(map);
//            for(Object o : map)
//                System.out.println(o);
        }
        return seatNumber2;
    }

    private static int countOccupiedSeat(List<String> strings) {
        char occupied = '#';
        int sum = 0;
        for (String s : strings) {
            char[] chars = s.toCharArray();
            for (char ch : chars)
                if (ch == occupied)
                    sum += 1;
        }
        return sum;
    }

    private static boolean checkIfNeedToChangeState(char ch, int occupiedAroundSeat) {
        char empty = 'L';
        char occupied = '#';
        if (ch == empty && occupiedAroundSeat == 0)
            return true;
        if (ch == occupied && occupiedAroundSeat >= 4)
            return true;
        return false;
    }

    private static int countOccupiedAroundSeat(List<String> strings, int seatRow, int seatNumber) {
        int sumOccupiedSeat = 0;
        char occupied = '#';
        for (int i = seatRow - 1; i < seatRow + 2; i++) {
            char[] chars = strings.get(i).toCharArray();
            for (int j = seatNumber - 1; j < seatNumber + 2; j++)
                if (!(i == seatRow && j == seatNumber) && chars[j] == occupied)
                    sumOccupiedSeat += 1;
        }
        return sumOccupiedSeat;
    }

    private static char changeSeatState(char ch) {
        switch (ch) {
            case '#':
                ch = 'L';
                break;
            case 'L':
                ch = '#';
        }
        return ch;
    }

    private static List<String> getChangedMap(List<String> input) {
        List<String> newMap = new ArrayList<>();
        for (String s : input)
            newMap.add("." + s + ".");
        String floor = "..";
        for (char ch : input.get(0).toCharArray())
            floor += ".";
        newMap.add(0, floor);
        newMap.add(floor);
        return newMap;
    }
}
