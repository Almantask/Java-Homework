package Advent;

import java.util.*;

public class Day6 {

    public static long solveDay6_1 (List<String> input) {
        List<String> rew = rewrite(input);
        long sumYes = 0;
        for (Object o : rew) {
            sumYes += countYes(o);
        }
        return sumYes;
    }

    public static int solveDay6_2 (List<String> input){
        List<String> rew = rewrite(input);
        int sumYes = 0;
        for (Object o : rew) {
            sumYes += countYes2(o);
        }
        return sumYes;
    }

    private static int countYes2(Object o) {
        List<String> answers = Arrays.asList(o.toString().split("[,; \t\n\r]+"));
        String max = Collections.max(answers, Comparator.comparing(String::length));
        char[] chars = max.toCharArray();
        int yes = 0;
        for (char ch : chars) {
            int sameChar = (int) answers.stream().filter(s -> s.indexOf(ch) > -1).count();
            if(sameChar != answers.size()){
                continue;
            }
            yes += 1;
        }
        return yes;
    }

    private static long countYes(Object o) {
        String a = o.toString().replace(" ", "");
        return a.chars().distinct().count();
    }

    private static List<String> rewrite(List<String> input) {
        List<String> rew = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < input.size(); i++) {
            Object o = input.get(i);
            if (!o.toString().equals("") && i < input.size() - 1) {
                s.append(o).append(" ");
                continue;
            }
            s.append(o).append(" ");
            rew.add(s.toString());
            s = new StringBuilder();
        }
        return rew;
    }
}
