package Advent;

import java.util.ArrayList;
import java.util.List;

public class Day17 {

    public static void solve(List<String> input) {
        System.out.println();
        System.out.println("The answer of Day17 Part1 is: " + solvePart1(input));
    }

    private static int solvePart1(List<String> input) {
        List<List<String>> pocket3D = create3DPocket(input);
        int cycle = 0;
        while (cycle < 6) {
            cycle += 1;
            pocket3D = changeAllCubesStates(increase3DPocket(pocket3D));   //increase areas and change cubes
        }
        return countActiveCube(pocket3D);
    }

    private static List<List<String>> changeAllCubesStates (List<List<String>> pocket){
        List<List<String>> changedPocket = new ArrayList<>();
        for (int i=0; i<pocket.size(); i++){
            List<String> area = pocket.get(i);
            List<String> newArea = new ArrayList<>();
            for(int j=0; j<area.size(); j++){
                String row = area.get(j);
                char[] cubes = new char[row.length()];
                for(int k=0; k<row.length(); k++){
                    int sumActiveNeighbors = countActiveNeighbors(pocket,i,j,k);
                    cubes[k] = changeOneCubeState(row.charAt(k),sumActiveNeighbors);
                }
                newArea.add(String.valueOf(cubes));
            }
            changedPocket.add(newArea);
        }
        return changedPocket;
    }

    private static int countActiveCube(List<List<String>> pocket3D) {
        int sumActiveCube = 0;
        for (List<String> area : pocket3D)
            for (String row : area)
                for (char cube : row.toCharArray())
                    if (isActiveCube(cube))
                        sumActiveCube += 1;
        return sumActiveCube;
    }

    private static List<List<String>> increase3DPocket(List<List<String>> pocket) {
        List<List<String>> increasedPocket = new ArrayList<>();
        for (List<String> area : pocket) {
            List<String> increasedArea = new ArrayList<>();
            increasedArea.add(createNewRow(area.size() + 2));
            for (String s : area)
                increasedArea.add("." + s + ".");
            increasedArea.add(createNewRow(area.size() + 2));
            increasedPocket.add(increasedArea);
        }
        increasedPocket.add(0, createNewArea(increasedPocket.get(0).size()));
        increasedPocket.add(createNewArea(increasedPocket.get(0).size()));
        return increasedPocket;
    }

    private static List<List<String>> create3DPocket(List<String> input) {
        List<List<String>> create3DPocket = new ArrayList<>();
        List<String> newArea = createNewArea(input.size());
        create3DPocket.add(input);
        return create3DPocket;
    }

    private static List<String> createNewArea(int size) {
        List<String> newArea = new ArrayList<>();
        String newRow = createNewRow(size);
        while (newArea.size() < size)
            newArea.add(newRow.toString());
        return newArea;
    }

    private static String createNewRow(int size) {
        StringBuilder newRow = new StringBuilder();
        while (newRow.length() < size)
            newRow.append(".");
        return String.valueOf(newRow);
    }

    private static int countActiveNeighbors(List<List<String>> thePocket, int list, int row, int column) {
        int sumOfActiveNeighbors = 0;
        for (int i = list - 1; i <= list + 1; i++) {
            if (i < 0 || i >= thePocket.size()) continue;   // check if checking area is first or last;
            List<String> checkingArea = thePocket.get(i);
            for (int j = row - 1; j <= row + 1; j++) {
                if (j < 0 || j >= checkingArea.size()) continue; // check if checking row is first or last;
                String checkingRow = checkingArea.get(j);
                for (int k = column - 1; k <= column + 1; k++) {
                    if (k < 0 || k >= checkingRow.length()) continue; // check if checking cube is first or last;
                    if (i == list && j == row && k == column) continue; // check if checking cube is the same as input;
                    char checkingCubes = checkingRow.toCharArray()[k];
                    if (isActiveCube(checkingCubes))
                        sumOfActiveNeighbors += 1;
                }
            }
        }
        return sumOfActiveNeighbors;
    }

    private static char changeOneCubeState(char cube, int sumActiveNeighbors) {
        switch (cube) {
            case '#':
                if (sumActiveNeighbors != 2 && sumActiveNeighbors != 3)
                    cube = '.';
                break;
            case '.':
                if (sumActiveNeighbors == 3)
                    cube = '#';
                break;
        }
        return cube;
    }

    private static boolean isActiveCube(char cube) {
        return cube == '#';
    }
}
