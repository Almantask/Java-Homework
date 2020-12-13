package Advent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day2 {

    public static int solveDay2(List input) {

        List limits = limitsList(input);
        List letters = lettersList(input);
        List codes = codesList(input);

        int sumValidPasswords= 0;
        for (int i = 0; i < limits.size(); i++) {
            if (passwordsValidation(limits.get(i).toString(), letters.get(i).toString(), codes.get(i).toString()) != true) {
                continue;
            }
            sumValidPasswords ++;
        }
        return sumValidPasswords;
    }

    public static int solveDay2_2(List input) {

        List limits = limitsList(input);
        List letters = lettersList(input);
        List codes = codesList(input);

        int sumValidPasswords2 = 0;
        for (int i = 0; i < limits.size(); i++) {
            if (passwordsValidation2(limits.get(i).toString(), letters.get(i).toString(), codes.get(i).toString()) != true) {
                continue;
            }
            sumValidPasswords2 ++;
        }
        return sumValidPasswords2;
    }

    private static boolean passwordsValidation(String limit, String letter, String code) {
        int countLettersInCode = code.length() - code.replace(letter, "").length();
        return countLettersInCode >= min(limit) && countLettersInCode <= max(limit);
    }

    private static boolean passwordsValidation2 (String limit, String letter, String code){
        char first = code.charAt(min(limit)-1);
        char second = code.charAt(max(limit)-1);
        char letter2= letter.charAt(0);
        return (Objects.equals(first, letter2) && !Objects.equals(second, letter2)) || (!Objects.equals(first, letter2) && Objects.equals(second, letter2));
    }

    private static List<String> limitsList(List<String> strings) {
        List<String> limits = new ArrayList<>();
        for (int i = 0; i < strings.size() / 3; i++) {
            limits.add(strings.get(i * 3));
        }
        return limits;
    }

    private static int min(String string) {
        String[] limits = string.split("-");
        return Integer.parseInt(limits[0]);
    }

    private static int max(String string) {
        String[] limits = string.split("-");
        return Integer.parseInt(limits[1]);
    }

    private static List<Character> lettersList(List<String> strings) {
        List<Character> letters = new ArrayList<Character>();
        for (int i = 0; i < strings.size() / 3; i++) {
            letters.add(strings.get((i * 3) + 1).charAt(0));
        }
        return letters;
    }

    private static List<String> codesList(List<String> strings) {
        ArrayList<String> codes = new ArrayList<String>();
        for (int i = 0; i < strings.size() / 3; i++) {
            codes.add(strings.get((i * 3) + 2));
        }
        return codes;
    }
}
