package main.java;

import java.util.*;

public class Calculator {
    static int calculate(String e) {
        if(e == null || e.length() < 1 || !Character.isDigit(e.charAt(0)) || !e.matches("[0-9|x%+!-]+"))
            return 0;
        e = factorialReplace(e);

        int[] numbers = firstJob(e.split("[+-]"), e.split("[0-9%x]+"));
        System.out.println(finalCalc(numbers, e.split("[0-9|%x]+")));

        return 1;
    }
    private static int[] firstJob(String multiplyDivideFirst[], String plusesMinuses[]) {
        int[] numbersNew = new int[10];

        for(int i = 0; i < multiplyDivideFirst.length; i++) {
            String numbers[] = multiplyDivideFirst[i].split("[x%]");
            String actions[] = multiplyDivideFirst[i].split("[0-9]+");
            int remap = Integer.parseInt(numbers[0]);
            for(int ii=1;ii<actions.length;ii++) {
                int nextNumber = Integer.parseInt(numbers[ii]);
                switch(actions[ii]) {
                    case "x":
                        remap *= nextNumber;
                        break;
                    case "%":
                        if(nextNumber > 0) {
                            remap /= nextNumber;
                        } else {
                            remap = -1;
                        }
                        break;

                }
            }
            numbersNew[i] = remap;
        }
        return numbersNew;
    }
    private static int finalCalc(int[] numbers, String[] operators) {
        int result = numbers[0];
        for(int i = 1; i < operators.length; i++) {
            switch (operators[i]) {
                case "+":
                    result += numbers[i];
                    break;
                case "-":
                    result -= numbers[i];
                    break;
            }
        }
        return result;
    }
    private static String factorialReplace(String work) {
        String workWith[] = work.split("([^0-9&!]+)");
        String returning = work;
        int replaceNumber = 0;
        for(int i=0; i< workWith.length; i++) {
            if(workWith[i].matches("[0-9]+[!$]")) {
                int number = Integer.parseInt(workWith[i].split("[!]")[0]);
                replaceNumber = number;
                for(int ii=number;ii > 1;ii--) {
                    replaceNumber *= (ii-1);
                }

                returning = returning.replaceAll("("+number+"!)",String.valueOf(replaceNumber));
            }
        }
        return returning;
    }
}
