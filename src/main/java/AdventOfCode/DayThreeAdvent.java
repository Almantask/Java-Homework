package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayThreeAdvent {

    private static List<String> lines = loadData("map.txt");
    private static final char magicValue = '#';

    public static void main(String[] args) {

        System.out.println(walk(1,1) * walk(3,1) * walk(5,1) * walk(7,1)
                * walk(1,2));

    }
    public static int walk (int right, int down) {
        int trees = 0;
        int horizonPosition = 0;
        for (int i = down; i < lines.size(); i += down) {
            horizonPosition += right;
            if (horizonPosition > lines.get(i).length() - 1) {
                horizonPosition = horizonPosition - lines.get(i).length();
            }
            if (lines.get(i).charAt(horizonPosition) == magicValue) {
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

        }
        return lines;
    }
}
