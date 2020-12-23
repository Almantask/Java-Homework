package Advent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day2 {

    public static void solve(List<String> input) {
        System.out.println("The answer of Day2 part1 is: " + solvePart1(input));
        System.out.println();
        System.out.println("The answer of Day2 part2 is: " + solvePart2(input));
    }

    public static int solvePart1(List<String> input) {
        List<int[]> limits = limitsList(input);
        char[] letters = lettersList(input);
        List<String> codes = codesList(input);
        int sumValidPasswords = 0;
        for (int i = 0; i < limits.size(); i++) {
            if (!passwordsValidation(limits.get(i), letters[i], codes.get(i)))
                continue;
            sumValidPasswords++;
        }
        return sumValidPasswords;
    }

    public static int solvePart2(List<String> input) {
        List<int[]> limits = limitsList(input);
        char[] letters = lettersList(input);
        List<String> codes = codesList(input);
        int sumValidPasswords = 0;
        for (int i = 0; i < limits.size(); i++) {
            if (!passwordsValidation2(limits.get(i), letters[i], codes.get(i))) {
                continue;
            }
            sumValidPasswords++;
        }
        return sumValidPasswords;
    }

    private static boolean passwordsValidation(int[] limit, char letter, String code) {
        int countLettersInCode = code.length() - code.replace(String.valueOf(letter), "").length();
        return countLettersInCode >= limit[0] && countLettersInCode <= limit[1];
    }

    private static boolean passwordsValidation2(int[] limit, char letter, String code) {
        char first = code.charAt(limit[0] - 1);
        char second = code.charAt(limit[1] - 1);
        return (Objects.equals(first, letter) && !Objects.equals(second, letter))
                || (!Objects.equals(first, letter) && Objects.equals(second, letter));
    }

    private static List<int[]> limitsList(List<String> input) {
        List<int[]> limits = new ArrayList<>();
        for (String s : input) {
            int[] minAndMax = new int[2];
            String limit = s.split(" ")[0];
            minAndMax[0] = Integer.parseInt(limit.split("-")[0]);
            minAndMax[1] = Integer.parseInt(limit.split("-")[1]);
            limits.add(minAndMax);
        }
        return limits;
    }

    private static char[] lettersList(List<String> input) {
        char[] letters = new char[input.size()];
        for (int i = 0; i < input.size(); i++)
            letters[i] = input.get(i).charAt(input.get(i).indexOf(":") - 1);
        return letters;
    }

    private static List<String> codesList(List<String> input) {
        List<String> codes = new ArrayList<>();
        for (String s : input)
            codes.add(s.split(" ")[2]);
        return codes;
    }
}
