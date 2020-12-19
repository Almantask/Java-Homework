package Advent;

import java.util.List;

public class Day12 {

    public static void solve(List<String> input) {

        System.out.println("The answer of Day12 part1 is : " + distance1(input));
        System.out.println();
        System.out.println("The answer of Day12 part2 is : " + distance2(input));
    }

    private static int distance2(List<String> input) {
        int shipPosition_E_W = 0;
        int shipPosition_N_S = 0;
        int wayPointPosition_E_W = 10;
        int wayPointPosition_N_S = 1;
        for (String s : input) {
            int steps = Integer.parseInt(s.split("(?<=\\D)(?=\\d)")[1]);
            char movingDirection = s.toCharArray()[0];
            switch (movingDirection) {
                case 'N':
                    wayPointPosition_N_S += steps;
                    break;
                case 'S':
                    wayPointPosition_N_S -= steps;
                    break;
                case 'E':
                    wayPointPosition_E_W += steps;
                    break;
                case 'W':
                    wayPointPosition_E_W -= steps;
                    break;
                case 'F':
                    shipPosition_E_W += wayPointPosition_E_W * steps;
                    shipPosition_N_S += wayPointPosition_N_S * steps;
                    break;
                case 'R':
                    int[] rotateRight = rotateWaypoint(steps, wayPointPosition_E_W, wayPointPosition_N_S);
                    wayPointPosition_E_W = rotateRight[0];
                    wayPointPosition_N_S = rotateRight[1];
                    break;
                case 'L':
                    int[] rotateLeft = rotateWaypoint(-steps, wayPointPosition_E_W, wayPointPosition_N_S);
                    wayPointPosition_E_W = rotateLeft[0];
                    wayPointPosition_N_S = rotateLeft[1];
                    break;
            }
        }
        return Math.abs(shipPosition_E_W) + Math.abs(shipPosition_N_S);
    }

    private static int[] rotateWaypoint(int rotateDegree, int waypointPosition_E_W, int waypointPosition_N_S) {
        int[] waypointPosition = {waypointPosition_E_W, waypointPosition_N_S};
        switch (rotateDegree) {
            case 90:
            case -270:
                waypointPosition[0] = waypointPosition_N_S;
                waypointPosition[1] = -waypointPosition_E_W;
                break;
            case 180:
            case -180:
                waypointPosition[0] = -waypointPosition_E_W;
                waypointPosition[1] = -waypointPosition_N_S;
                break;
            case 270:
            case -90:
                waypointPosition[0] = -waypointPosition_N_S;
                waypointPosition[1] = waypointPosition_E_W;
                break;
        }
        return waypointPosition;
    }

    private static int distance1(List<String> input) {
        int positionNorthSouth = 0;
        int positionEastWest = 0;
        char faceDirection = 'E';
        for (String s : input) {
            int steps = Integer.parseInt(s.split("(?<=\\D)(?=\\d)")[1]);
            char movingDirection = s.toCharArray()[0];
            if (movingDirection == 'F')
                movingDirection = faceDirection;
            switch (movingDirection) {
                case 'N':
                    positionNorthSouth += steps;
                    break;
                case 'S':
                    positionNorthSouth -= steps;
                    break;
                case 'E':
                    positionEastWest += steps;
                    break;
                case 'W':
                    positionEastWest -= steps;
                    break;
                case 'R':
                    faceDirection = rotateShip(steps, faceDirection);
                    break;
                case 'L':
                    faceDirection = rotateShip(-steps, faceDirection);
                    break;
            }
//            System.out.println(s + " : East/West " + positionEastWest + ", North/South " + positionNorthSouth);
        }
        return Math.abs(positionEastWest) + Math.abs(positionNorthSouth);
    }

    private static char rotateShip (int degree, char facePosition){
        String directions = "ESWNESWN";
        char direction = facePosition;
        int position = directions.indexOf(facePosition);
        switch (degree){
            case 90 :
            case -270 :
                direction = directions.charAt(position+1);
                break;
            case 180:
            case -180:
                direction = directions.charAt(position+2);
                break;
            case 270:
            case -90:
                direction = directions.charAt(position+3);
                break;
        }
        return direction;
    }
}

