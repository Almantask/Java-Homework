package Calculator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("([0-9]*)([+-x\\%!])([0-9]*)");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("q")) {
                break;
            }
            System.out.println("Result: " + calculate(expression));
        }
    }

    private static int calculate(String expression) {
        if (expression.equals("")) {
            return 0;
        }
        Matcher matcher = EXPRESSION_PATTERN.matcher(expression);
        if (!matcher.matches()) {
            System.out.println("Invalid expression.");
            return 0;
        }
        int argument1 = Integer.parseInt(matcher.group(1));
        Integer argument2 = null;
        String group3 = matcher.group(3);
        if (group3 != null && !group3.equals("")) {
            argument2 = Integer.parseInt(group3);
        }
        int result = 0;
        switch (matcher.group(2)) {
            case "+":
                result = argument1 + argument2;
                break;
            case "-":
                result = argument1 - argument2;
                break;
            case "x":
                result = argument1 * argument2;
                break;
            case "%":
                if (argument2 != 0) {
                    result = argument1 / argument2;
                } else {
                    result = -1;
                }
                break;
            case "!":
                result = factorial(argument1);
                break;
            default:
                break;
        }
        return result;
    }

    private static int factorial(int number) {
        int result = 1;
        for (int i = number; i > 0; i--) {
            result = result * i;
        }
        return result;
    }
}
