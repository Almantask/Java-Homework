package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayFourAdvent {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(readFile("passportInfo.txt"));
        List<String> file = readFile("passportInfo.txt");
        validPassports(file);

    }

    public static int validPassports(List<String> file) {
        for (int i = 0; i < file.size(); i++) {
            String [] keys = file.get(i).split("[,: ]");
            System.out.println(Arrays.toString(keys));

            if (file.get(i).isEmpty()) {
                System.out.println(i);
            }

        }
        return 1;
    }

    public static List<String> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<String> tall = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            tall.add(scanner.nextLine());
        }
        return tall;
    }
}
