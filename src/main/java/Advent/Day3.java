package Advent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day3 {

    public static long solveDay3(List input) {

        long trees_R1D1 = Collections.frequency(treesList(input, 1, 1), '#');
        long trees_R3D1 = Collections.frequency(treesList(input, 3, 1), '#');
        long trees_R5D1 = Collections.frequency(treesList(input, 5, 1), '#');
        long trees_R7D1 = Collections.frequency(treesList(input, 7, 1), '#');
        long trees_R1D2 = Collections.frequency(treesList(input, 1, 2), '#');

        return trees_R1D1 * trees_R1D2 * trees_R3D1 * trees_R5D1 * trees_R7D1;
    }

    private static ArrayList treesList (List input, int rightStep, int downStep) {
        ArrayList list = new ArrayList();
        int position = 0;
        for (int i = 0; i < input.size(); i = i + downStep) {
            Object o = input.get(i);
            list.add(o.toString().charAt(position));
            position += rightStep;
            if (position < o.toString().length()) {
                continue;
            }
            position = position - o.toString().length();
        }
        return list;
    }
}
