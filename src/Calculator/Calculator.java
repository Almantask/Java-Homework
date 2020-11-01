package Calculator;

public class Calculator {
    private char[] defaultOperators = {'+', '-', 'x', '%', '/', '!'};
    private char[] charArray;

    public int calculate(String expression) {
        if (expression.isEmpty() || expression.equals("")) {
            return 0;
        }
        charArray = expression.toCharArray();
        int result = Integer.parseInt(String.valueOf(charArray[0]));
        for (int i = 1; i < charArray.length; i = i + 2) {
            if ((i + 1) != charArray.length) {
                result = operation(result, charArray[i], Integer.parseInt(String.valueOf(charArray[i + 1])));
            } else result = operation(result, charArray[i], 0);
        }
        return result;
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
