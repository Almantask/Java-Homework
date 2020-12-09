package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayThreeAdvent {

    public static void main(String[] args) {
        int first = walk(1,1);
        int second = walk(3,1);
        int third = walk(5,1);
        int fourth = walk(7,1);
        int fifth = walk(1,2);

        int answer = first * second * third * fourth * fifth;
        System.out.println(answer);

    }
    public static int walk (int right, int down) {
        List<String> lines = loadData("map.txt");
        int trees = 0;
        int horizonPosition = 0;
        for (int i = down; i < lines.size(); i += down) {
            horizonPosition += right;
            if (horizonPosition > lines.get(i).length() - 1) {
                horizonPosition = horizonPosition - lines.get(i).length();
            }
            if (lines.get(i).charAt(horizonPosition) == '#') {
                trees++;
            }
        }
        return trees;
    }

    private static List<String> loadData (String fileName){
        List<String> lines = new ArrayList<>();
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        return lines;
    }
}
