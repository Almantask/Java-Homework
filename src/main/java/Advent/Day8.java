package Advent;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Day8 {

    public static void solve(List<String> input) {

        System.out.println("Answer of Day8 part 1 is: " + countAccumulator_Part1(input));
        System.out.println();
        System.out.println("Answer of Day8 part 2 is: " + countAccumulator_Part1(fixedInstructions(input)));
    }

    private static List<String> fixedInstructions(List<String> input) {
        List<String> instructionsToChange = new ArrayList<>(input);
        for (int i = 0; i < instructionsToChange.size(); i++) {
            String s = instructionsToChange.get(i);
            List<String> instructions = new ArrayList<>(input);
            if (s.contains("acc")) continue;
            switch (operatorAndArgument(s).get(0).toString()) {
                case "nop":
                    s = s.replace("nop", "jmp");
                    break;
                case "jmp":
                    s = s.replace("jmp", "nop");
            }
            instructions.set(i, s);
            int j = 0;
            while (true){
//                if (j >= instructions.size()) break;
                String instruction = instructions.get(j);
                String operator = operatorAndArgument(instruction).get(0).toString();
                int argument = Integer.parseInt(operatorAndArgument(instruction).get(1).toString());
                instructions.set(j, "");
                if (operator.equals("jmp")) {
                    j += argument;
                } else {
                    j += 1;
                }
                if(j == instructions.size()) break;
                if (instructions.get(j).isEmpty()) break;
           }
            if(!(j >= instructions.size())) continue;
            instructionsToChange.set(i, s);
        }
            return instructionsToChange;
        }

        private static int countAccumulator_Part1 (List < String > input) {
            List<String> instructions = new ArrayList<>(input);
            int i = 0;
            int accumulator = 0;
            while (i < instructions.size() && i >= 0 && !instructions.get(i).isEmpty()) {
                String instruction = instructions.get(i);
                String operator = (String) operatorAndArgument(instruction).get(0);
                int argument = Integer.parseInt(operatorAndArgument(instruction).get(1).toString());
                instructions.set(i, "");
                switch (operator) {
                    case "nop":
                        i += 1;
                        break;
                    case "acc":
                        accumulator += argument;
                        i += 1;
                        break;
                    case "jmp":
                        i += argument;
                        break;
                }
            }
            return accumulator;
        }

        private static List<Object> operatorAndArgument (String s){
            return Arrays.asList(s.split(" "));
        }
    }
