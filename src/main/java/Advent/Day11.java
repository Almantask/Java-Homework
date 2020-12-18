package Advent;

import java.util.ArrayList;
import java.util.List;

public class Day11 {

    public static void solve(List<String> input) {

        System.out.println("The answer of Day 11 part 1 is : " + countAllOccupiedSeat(input));
        System.out.println();
        System.out.println("The answer of Day 11 part 2 is : " + countAllOccupiedSeat2(input));
    }

    private static int countFirstSeenOccupiedSeat(List<String> strings, int seatRow, int seatNumber) {
        int sumOccupiedSeat = 0;
        char occupiedSeat = '#';
        int[] firstSeat = {-1, -1};
        int[] secondSeat = {-1, 0};
        int[] thirdSeat = {-1, 1};
        int[] fourthSeat = {0, -1};
        int[] fifthSeat = {0, 1};
        int[] sixthSeat = {1, -1};
        int[] seventhSeat = {1, 0};
        int[] eighthSeat = {1, 1};
        List<int[]> instructions = new ArrayList<>();
        instructions.add(firstSeat);
        instructions.add(secondSeat);
        instructions.add(thirdSeat);
        instructions.add(fourthSeat);
        instructions.add(fifthSeat);
        instructions.add(sixthSeat);
        instructions.add(seventhSeat);
        instructions.add(eighthSeat);
        for (int[] ints : instructions) {
            char floor = '.';
            int row = seatRow + ints[0];
            int col = seatNumber + ints[1];
            char seenSeat = strings.get(row).toCharArray()[col];
            while (row > 0 && col > 0 &&
                    row < strings.size() && col < strings.get(row).length() &&
                    seenSeat == floor) {
                seenSeat = strings.get(row).toCharArray()[col];
                row += ints[0];
                col += ints[1];
            }
            if (seenSeat == occupiedSeat)
                sumOccupiedSeat += 1;
        }
        return sumOccupiedSeat;
    }

    private static int countAllOccupiedSeat2(List<String> input) {
        List<String> map = getChangedMap(input);
        int seatNumber1 = 0;
        int seatNumber2 = 1;
        while (seatNumber1 != seatNumber2) {
            List<String> changedMap = new ArrayList<>(map);
            seatNumber1 = countOccupiedSeat(map);
            for (int i = 1; i < changedMap.size() - 1; i++) {
                char[] seats = changedMap.get(i).toCharArray();
                for (int j = 1; j < seats.length - 1; j++) {
                    if (checkIfNeedToChangeState2(seats[j], countFirstSeenOccupiedSeat(changedMap, i, j)))
                        seats[j] = changeSeatState(seats[j]);
                }
                map.set(i, String.valueOf(seats));
            }
            seatNumber2 = countOccupiedSeat(map);
        }
        return seatNumber2;
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
        return ch == occupied && occupiedAroundSeat >= 4;
    }

    private static boolean checkIfNeedToChangeState2(char ch, int occupiedAroundSeat) {
        char empty = 'L';
        char occupied = '#';
        if (ch == empty && occupiedAroundSeat == 0)
            return true;
        return ch == occupied && occupiedAroundSeat >= 5;
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
        StringBuilder floor = new StringBuilder("..");
        for (char ignored : input.get(0).toCharArray()) {
            floor.append(".");
        }
        newMap.add(0, floor.toString());
        newMap.add(floor.toString());
        return newMap;
    }
}
