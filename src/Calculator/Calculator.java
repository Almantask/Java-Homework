package Calculator;

public class Calculator {
    private char[] operators = {'+', '-', 'x', '%', '/', '!'};

    public int calculate(String expression) {
        if (expression.isEmpty() || expression.equals("")) {
            return 0;
        }

        String[] arguments = expression.split("[-+%/x!]");
        char[] expressionOperators = getExpressionOperators(expression);
        int result = Integer.parseInt(String.valueOf(arguments[0]));
        for (int i = 0; i < expressionOperators.length; i++) {
            if (i + 1 != arguments.length) {
                result = operation(result, expressionOperators[i], Integer.parseInt(String.valueOf(arguments[i + 1])));
            } else result = operation(result, expressionOperators[i], 0);
        }
        return result;
    }

    private char[] getExpressionOperators(String expression) {
        char[] charArray = expression.toCharArray();
        char[] expressionOperators = new char[0];

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < operators.length; j++) {
                if (charArray[i] == operators[j]) {
                    expressionOperators = Arrays.biggerArray(expressionOperators);
                    expressionOperators[expressionOperators.length - 1] = operators[j];
                }
            }
        }
        return expressionOperators;
    }

    private Integer operation(int arg1, char operator, int arg2) {
        switch (operator) {
            case '+':
                return arg1 + arg2;
            case '-':
                return arg1 - arg2;
            case 'x':
                return arg1 * arg2;
            case '%':
            case '/':
                if (arg2 != 0) {
                    return arg1 / arg2;
                } else return -1;
            case '!':
                return factorial(arg1);
            default:
                return null;
        }
    }

    private int factorial(int arg1) {
        int result = arg1;
        for (int i = arg1 - 1; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}
