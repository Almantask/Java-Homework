package Advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day18 {

    public static void solve(List<String> input) {

        System.out.println();
        System.out.println("The answer of Day18 Part1 is: " + solvePart1(input));
        System.out.println();
        System.out.println("The answer of Day18 part2 is: " + solvePart2(input));
    }

    private static long solvePart1(List<String> input) {
        long sumOfAllRowValues = 0;
        for (String s : input) {
            sumOfAllRowValues += countOneRow(changeRowToList(s));
        }
        return sumOfAllRowValues;
    }

    private static long solvePart2(List<String> input) {
        long sumOfAllRowValues = 0;
        for (String s : input) {
            sumOfAllRowValues += countOneRowPart2(changeRowToList(s));
        }
        return sumOfAllRowValues;
    }

    private static long countOneRowPart2(List<String> row) {
        List<String> expressionsWithoutParentheses = new ArrayList<>(row);
        while (expressionsWithoutParentheses.toString().contains("(")) {
            List<String> expression = findExpressionWithoutParentheses(expressionsWithoutParentheses);
            expressionsWithoutParentheses = changeRowPart2(expressionsWithoutParentheses, expression);
        }
        return countExpressionPart2(expressionsWithoutParentheses);
    }

    private static List<String> changeRowPart2(List<String> row, List<String> expressionInParentheses) {
        String rowToString = row.toString().replaceAll("[\\[\\]]", "");
        String expression = "(" + expressionInParentheses.toString().replaceAll("[\\[\\]]", "") + ")";
        String expressionAnswer = String.valueOf(countExpressionPart2(expressionInParentheses));
        String changedRow = rowToString.replace(expression, expressionAnswer);
        List<String> changed = Arrays.asList(changedRow.split(", "));
        return changed;
    }

    private static long countExpressionPart2(List<String> expression) {
        long answer = 1;
        List<String> newExpression = new ArrayList<>(expression);
        for (int i = newExpression.size() - 2; i>=0; i-=2) {
            String operator = expression.get(i);
            switch (operator) {
                case "+":
                    newExpression.set(i, String.valueOf(Long.parseLong(newExpression.get(i-1))+Long.parseLong(newExpression.get(i+1))));
                    newExpression.remove(i+1);
                    newExpression.remove(i-1);
                    break;
                case "*":
                    newExpression.remove(i);
                    break;
            }
        }
        answer *= newExpression.stream().mapToLong(Long::parseLong).reduce(1, (a, b) -> a * b);
        return answer;
    }

    private static long countOneRow(List<String> row) {
        List<String> expressionsWithoutParentheses = new ArrayList<>(row);
        while (expressionsWithoutParentheses.toString().contains("(")) {
            List<String> expression = findExpressionWithoutParentheses(expressionsWithoutParentheses);
            expressionsWithoutParentheses = changeRow(expressionsWithoutParentheses, expression);
        }
        return countExpression(expressionsWithoutParentheses);
    }

    private static List<String> changeRow(List<String> row, List<String> expressionInParentheses) {
        String rowToString = row.toString().replaceAll("[\\[\\]]", "");
        String expression = "(" + expressionInParentheses.toString().replaceAll("[\\[\\]]", "") + ")";
        String expressionAnswer = String.valueOf(countExpression(expressionInParentheses));
        String changedRow = rowToString.replace(expression, expressionAnswer);
        List<String> changed = Arrays.asList(changedRow.split(", "));
        return changed;
    }

    private static List<String> findExpressionWithoutParentheses(List<String> input) {
        List<String> expressionsWithoutParentheses = new ArrayList<>(input);
        while (getExpressionsInParentheses(expressionsWithoutParentheses).size() > 1) {
            expressionsWithoutParentheses = getExpressionsInParentheses(expressionsWithoutParentheses);
        }
        return expressionsWithoutParentheses;
    }

    private static long countExpression(List<String> expression) {
        long answer = Long.parseLong(expression.get(0));
        for (int i = 1; i < expression.size() - 1; i += 2) {
            String operator = expression.get(i);
            long nextNumber = Long.parseLong(expression.get(i + 1));
            switch (operator) {
                case "+":
                    answer += nextNumber;
                    break;
                case "*":
                    answer *= nextNumber;
                    break;
            }
        }
        return answer;
    }

    private static List<String> getExpressionsInParentheses(List<String> rowList) {
        List<String> expressionsInParentheses = new ArrayList<>();
        int openParentheses = 0;
        int closeParentheses = 0;
        for (String element : rowList) {
            if (element.contains("("))                              //find first parentheses (when openParentheses = 1; closeParentheses = 0)
                openParentheses += getNumberOfParentheses(element);
            if (openParentheses > closeParentheses)
                expressionsInParentheses.add(element);
            if (element.contains(")")) {                            //find last parentheses witch close first parentheses (when openParentheses = closeParentheses)
                closeParentheses += getNumberOfParentheses(element);
                if (openParentheses == closeParentheses)
                    break;
            }
        }
        expressionsInParentheses = removeFirstAndLastParentheses(expressionsInParentheses);
        return expressionsInParentheses;
    }

    private static List<String> removeFirstAndLastParentheses(List<String> expression) {
        List<String> removedParentheses = new ArrayList<>(expression);
        if (!expression.isEmpty()) {
            removedParentheses.set(0, expression.get(0).replaceFirst("\\(", ""));
            int lastElement = expression.size() - 1;
            removedParentheses.set(lastElement, expression.get(lastElement).replaceAll("[)]$", ""));
        }
        return removedParentheses;
    }

    private static int getNumberOfParentheses(String string) {
        return string.length() - string.replaceAll("[()]", "").length();
    }

    private static List<String> changeRowToList(String row) {
        return new ArrayList<>(Arrays.asList(row.split(" ")));
    }

}
