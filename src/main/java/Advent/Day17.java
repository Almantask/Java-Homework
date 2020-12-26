package Advent;

import java.util.ArrayList;
import java.util.List;

public class Day17 {

    public static void solve(List<String> input) {
        System.out.println();
        System.out.println("The answer of Day17 Part1 is: " + solvePart1(input));
        System.out.println();
        System.out.println("The answer of Day17 Part2 is: " + solvePart2(input));
    }

    private static int solvePart1(List<String> input) {
        List<List<String>> pocket3D = create3DPocket(input);
        int cycle = 0;
        while (cycle < 6) {
            cycle += 1;
            pocket3D = changeAll3DPocketCubesStates(increase3DPocket(pocket3D));   //increase areas and change cubes
        }
        return countActiveCubeIn3DPocket(pocket3D);
    }

    private static int solvePart2(List<String> input) {
        List<List<List<String>>> pocket4D = create4DPocket(input);
        int cycle = 0;
        while (cycle < 6) {
            cycle += 1;
            pocket4D = changeAll4DPocketCubesState(increase4DPocket(pocket4D));
        }
        return countAllActiveCubeIn4DPocket(pocket4D);
    }

    private static List<List<List<String>>> create4DPocket(List<String> input) {
        List<List<List<String>>> newPocket4D = new ArrayList<>();
        List<List<String>> new3DPocket = create3DPocket(input);
        new3DPocket.add(0, createNewArea(input.size()));
        new3DPocket.add(createNewArea(input.size()));
        newPocket4D.add(new3DPocket);
        return newPocket4D;
    }

    private static List<List<String>> createEmpty3DPocket(int size) {
        List<List<String>> newEmpty3DPocket = new ArrayList<>();
        while (newEmpty3DPocket.size() < size)
            newEmpty3DPocket.add(createNewArea(size));
        return newEmpty3DPocket;
    }

    private static List<List<List<String>>> increase4DPocket(List<List<List<String>>> pocket4D) {
        List<List<List<String>>> increased4DPocket = new ArrayList<>();
        for (List<List<String>> pocket3D : pocket4D)
            increased4DPocket.add(increase3DPocket(pocket3D));
        increased4DPocket.add(0, createEmpty3DPocket(increased4DPocket.get(0).get(0).size()));
        increased4DPocket.add(createEmpty3DPocket(increased4DPocket.get(0).get(0).size()));
        return increased4DPocket;
    }

    private static List<List<List<String>>> changeAll4DPocketCubesState(List<List<List<String>>> pocket4D) {
        List<List<List<String>>> changed4DPocket = new ArrayList<>();
        for (int w = 0; w < pocket4D.size(); w++) {
            List<List<String>> pocket3D = pocket4D.get(w);
            List<List<String>> changedPocket3D = new ArrayList<>();
            for (int i = 0; i < pocket3D.size(); i++) {
                List<String> area = pocket3D.get(i);
                List<String> newArea = new ArrayList<>();
                for (int j = 0; j < area.size(); j++) {
                    String row = area.get(j);
                    char[] cubes = new char[row.length()];
                    for (int k = 0; k < row.length(); k++) {
                        int sumActiveNeighbors = countActiveNeighborsIn4DPocket(pocket4D, w, i, j, k);
                        cubes[k] = changeOneCubeState(row.charAt(k), sumActiveNeighbors);
                    }
                    newArea.add(String.valueOf(cubes));
                }
                changedPocket3D.add(newArea);
            }
            changed4DPocket.add(changedPocket3D);
        }
        return changed4DPocket;
    }

    private static int countActiveNeighborsIn4DPocket(List<List<List<String>>> pocket4D, int pocket, int list, int row, int column) {
        int sumOfActiveNeighbors = 0;
        for (int w = pocket - 1; w <= pocket + 1; w++) {
            if (w < 0 || w >= pocket4D.size()) continue;
            List<List<String>> checking3DPocket = pocket4D.get(w);
            for (int i = list - 1; i <= list + 1; i++) {
                if (i < 0 || i >= checking3DPocket.size()) continue;   // check if checking area is first or last;
                List<String> checkingArea = checking3DPocket.get(i);
                for (int j = row - 1; j <= row + 1; j++) {
                    if (j < 0 || j >= checkingArea.size()) continue; // check if checking row is first or last;
                    String checkingRow = checkingArea.get(j);
                    for (int k = column - 1; k <= column + 1; k++) {
                        if (k < 0 || k >= checkingRow.length()) continue; // check if checking cube is first or last;
                        if (w == pocket && i == list && j == row && k == column)
                            continue; // check if checking cube is the same as input;
                        char checkingCubes = checkingRow.toCharArray()[k];
                        if (cubeIsActive(checkingCubes))
                            sumOfActiveNeighbors += 1;
                    }
                }
            }
        }
        return sumOfActiveNeighbors;
    }

    private static int countAllActiveCubeIn4DPocket(List<List<List<String>>> pocket4D) {
        int sumActiveCube = 0;
        for (List<List<String>> pocket3D : pocket4D)
            sumActiveCube += countActiveCubeIn3DPocket(pocket3D);
        return sumActiveCube;
    }

    private static List<List<String>> changeAll3DPocketCubesStates(List<List<String>> pocket) {
        List<List<String>> changedPocket = new ArrayList<>();
        for (int i = 0; i < pocket.size(); i++) {
            List<String> area = pocket.get(i);
            List<String> newArea = new ArrayList<>();
            for (int j = 0; j < area.size(); j++) {
                String row = area.get(j);
                char[] cubes = new char[row.length()];
                for (int k = 0; k < row.length(); k++) {
                    int sumActiveNeighbors = countActiveNeighborsIn3DPocket(pocket, i, j, k);
                    cubes[k] = changeOneCubeState(row.charAt(k), sumActiveNeighbors);
                }
                newArea.add(String.valueOf(cubes));
            }
            changedPocket.add(newArea);
        }
        return changedPocket;
    }

    private static int countActiveCubeIn3DPocket(List<List<String>> pocket3D) {
        int sumActiveCube = 0;
        for (List<String> area : pocket3D)
            for (String row : area)
                for (char cube : row.toCharArray())
                    if (cubeIsActive(cube))
                        sumActiveCube += 1;
        return sumActiveCube;
    }

    private static List<List<String>> increase3DPocket(List<List<String>> pocket3D) {
        List<List<String>> increased3DPocket = new ArrayList<>();
        for (List<String> area : pocket3D) {
            List<String> increasedArea = new ArrayList<>();
            increasedArea.add(createNewRow(area.size() + 2));
            for (String s : area)
                increasedArea.add("." + s + ".");
            increasedArea.add(createNewRow(area.size() + 2));
            increased3DPocket.add(increasedArea);
        }
        increased3DPocket.add(0, createNewArea(increased3DPocket.get(0).size()));
        increased3DPocket.add(createNewArea(increased3DPocket.get(0).size()));
        return increased3DPocket;
    }

    private static List<List<String>> create3DPocket(List<String> input) {
        List<List<String>> create3DPocket = new ArrayList<>();
        create3DPocket.add(input);
        return create3DPocket;
    }

    private static List<String> createNewArea(int size) {
        List<String> newArea = new ArrayList<>();
        String newRow = createNewRow(size);
        while (newArea.size() < size)
            newArea.add(newRow);
        return newArea;
    }

    private static String createNewRow(int size) {
        StringBuilder newRow = new StringBuilder();
        while (newRow.length() < size)
            newRow.append(".");
        return String.valueOf(newRow);
    }

    private static int countActiveNeighborsIn3DPocket(List<List<String>> thePocket3D, int list, int row, int column) {
        int sumOfActiveNeighbors = 0;
        for (int i = list - 1; i <= list + 1; i++) {
            if (i < 0 || i >= thePocket3D.size()) continue;   // check if checking area is first or last;
            List<String> checkingArea = thePocket3D.get(i);
            for (int j = row - 1; j <= row + 1; j++) {
                if (j < 0 || j >= checkingArea.size()) continue; // check if checking row is first or last;
                String checkingRow = checkingArea.get(j);
                for (int k = column - 1; k <= column + 1; k++) {
                    if (k < 0 || k >= checkingRow.length()) continue; // check if checking cube is first or last;
                    if (i == list && j == row && k == column)
                        continue; // check if checking cube is the same as input;
                    char checkingCubes = checkingRow.toCharArray()[k];
                    if (cubeIsActive(checkingCubes))
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

    private static boolean cubeIsActive(char cube) {
        return cube == '#';
    }
}
