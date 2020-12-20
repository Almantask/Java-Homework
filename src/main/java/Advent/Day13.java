package Advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {

    public static void solve(List<String> input) {

        System.out.println();
        System.out.println("The answer of Day13 part1 is: " + solvePart1(input));
        System.out.println();
        solvePart2(input);

    }

    private static long solvePart2(List<String> input) {
        List<int[]> busIDsAndDepartDif = getBusIDAndDepartDifferences(input);
        long maxBusID = 0; // 310357331l
        long timeDifferent = 0;
        for(int[] o : busIDsAndDepartDif)
            if(o[0] > maxBusID){
                maxBusID = o[0];
                timeDifferent = o[1];
            }
        System.out.println("maxBusID = " + maxBusID);
        System.out.println(timeDifferent);
        long timestamp = maxBusID - timeDifferent; // 19380331813222l
        long timestamp2 = 0;
        while (timestamp > timestamp2) {
            timestamp2 = timestamp;
            int check = 0;
            for (int[] o : busIDsAndDepartDif) {
                long a = (timestamp + o[1]) / o[0];
                if ((a*o[0]-o[1]) == timestamp)
                    continue;
                check += 1;
            }
            if (check > 0)
                timestamp += maxBusID;
            System.out.println("timestamp = " + timestamp);
        }
        System.out.println(input);
        return timestamp;
    }

    private static List<int[]> getBusIDAndDepartDifferences(List<String> input) {
        List<int[]> busID_timeDepart = new ArrayList<>();
        List<String> busIDs = new ArrayList(Arrays.asList(input.get(1).split(",")));
        for (int i = 0; i < busIDs.size(); i++) {
            if (busIDs.get(i).equals("x"))
                continue;
            int busID = Integer.parseInt(busIDs.get(i));
            int[] idAndTime = {busID, i};
            busID_timeDepart.add(idAndTime);
        }
        return busID_timeDepart;
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
//        System.out.println("time: " + time + ", waitingTime: " + waitingTime + ", busID: " + busID);
        return busID * waitingTime;
    }
}
