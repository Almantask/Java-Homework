package Advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {

    public static void solve(List<String> input) {

        System.out.println(input);
        System.out.println();
        System.out.println(solvePart1(input));

    }

    private static int solvePart1(List<String> input) {
        int time = Integer.parseInt(input.get(0));
        String buses = input.get(1).replace("x,", "");
        List<String> busNumbers = new ArrayList<>(Arrays.asList(buses.split(",")));
        int waitingTime = time;
        int busID = 0;
        for (String s : busNumbers) {
            int busNumber = Integer.parseInt(s);
            int nextDeparture = (time / busNumber + 1) * busNumber;
            int waiting = nextDeparture - time;
            if (waiting < waitingTime) {
                waitingTime = waiting;
                busID = busNumber;
            }
        }
        System.out.println("time: " + time + ", waitingTime: " + waitingTime + ", busID: " + busID);
        return busID * waitingTime;
    }
}
