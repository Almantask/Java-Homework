package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayOneAdvent {

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> numbers = readFile("numbers.txt");

        System.out.println(findTwoNumber(numbers));
        System.out.println(findThreeNumber(numbers));

    }

    public static int findTwoNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == 2020) {
                    return numbers.get(i) * numbers.get(j);
                }
            }
        }
        return -1;
    }

    public static int findThreeNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 1; j < numbers.size(); j++) {
                for (int k = 2; k < numbers.size(); k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == 2020) {
                        return numbers.get(i) * numbers.get(j) * numbers.get(k);
                    }
                }
            }
        }
        return -1;
    }

    public static List<Integer> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Integer> tall = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            tall.add(scanner.nextInt());
        }
        return tall;
    }
}
