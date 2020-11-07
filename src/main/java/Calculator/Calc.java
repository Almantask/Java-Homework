package Calculator;



import java.util.Arrays;

    public class Calc {

        public static void main(String[] args) {
            System.out.println("Empty string = " + calculate(""));
            System.out.println("8 + 5/0 = " + calculate("8 + 5/0"));
            System.out.println("1+7.2 = " + calculate("1+7.2"));
            System.out.println("4+A = " + calculate("4+A"));
            System.out.println("5x3+2x7+1-5 = " + calculate("5x3+2x7+1-5"));
            System.out.println("5x3+2x7+1-53 = " + calculate("5x3+2x7+1-53"));
            System.out.println("5x3+2x7+1-5+4! = " + calculate("5x3+2x7+1-5+4!"));
            System.out.println("5x1+2-4! = " + calculate("5x1+2-4!"));
            System.out.println("4+7/3 = " + calculate("4+7/3"));
        }

        private static int calculate(String expression) {
            // 0- Empty
            // Empty string "" should return 0.
            if (expression == null || expression.isEmpty()) {
                return 0;
            }
            // 3 - Division from 0
            // Division from zero should not be possible. If a string "5/0" is passed, result should be -1
            if (expression.contains("/0")) {
                return -1;
            }
            // 4 - Floating point numbers
            // As mentioned, floating point numbers should not be supported. If string contains not a whole number and not the allowed operations (+-x%) then it should also return -1.
            if (expression.contains(".") || !hasOnlyAllowedChars(expression, "0123456789+-x/!")) {
                return -1;
            }
            // calculate
            // find partial formulas: 5x3+2x7+1-5+4! -> ["5x3", "2x7", "1", "5", "4!"]
            String[] operands = findOperands(expression, "+-");
            // find operators: 5x3+2x7+1-5+4! -> ["+", "+", "-", "+"]
            String[] plusMinus = findOperators(expression, "+-");
            // calculates division, multiplication, factorial: 5x3, 2x7, 1, 5, 4!
            int result = findNumberDivMultiFactorial(operands[0]);
            for (int i = 1; i < operands.length; i++) {
                switch (plusMinus[i - 1]) {
                    case "+":
                        result = result + findNumberDivMultiFactorial(operands[i]);
                        break;
                    case "-":
                        result = result - findNumberDivMultiFactorial(operands[i]);
                        break;
                }
            }

            return result;
        }

        private static int findNumberDivMultiFactorial(String expression) {

            String[] operands = findOperands(expression, "x/");
            String[] operators = findOperators(expression, "x/");
            int result = findNumberOrFactorial(operands[0]);
            for (int i = 1; i < operands.length; i++) {
                switch (operators[i - 1]) {
                    case "x":
                        result = result * findNumberOrFactorial(operands[i]);
                        break;
                    case "/":
                        result = result / findNumberOrFactorial(operands[i]);
                        break;
                }
            }
            return result;
        }

        private static int findNumberOrFactorial(String numberOrFactorial) {
            int result = 1;
            if (numberOrFactorial.endsWith("!")) {
                String number = numberOrFactorial.substring(0, numberOrFactorial.length() - 1);
                for (int i = 2; i <= Integer.parseInt(number); i++) {
                    result = result * i;
                }
            } else {
                result = Integer.parseInt(numberOrFactorial);
            }
            return result;
        }

        private static String[] findOperands(String expression, String operators) {
            String[] result = new String[]{};
            String operand = "";
            for (int i = 0; i < expression.length(); i++) {
                String substring = expression.substring(i, i + 1);
                if (!operators.contains(substring)) {
                    operand = operand + substring;
                } else {
                    result = appendToArray(result, operand);
                    operand = "";
                }
            }
            result = appendToArray(result, operand);
            return result;
        }

        private static String[] findOperators(String expression, String operators) {
            String[] result = new String[]{};
            for (int i = 0; i < expression.length(); i++) {
                String symbol = expression.substring(i, i + 1);
                if (operators.contains(symbol)) {
                    result = appendToArray(result, symbol);
                }
            }
            return result;
        }

        private static String[] appendToArray(String[] arr, String element) {
            int length = arr.length;
            arr = Arrays.copyOf(arr, length + 1);
            arr[length] = element;
            return arr;
        }

        private static boolean hasOnlyAllowedChars(String expression, String allowedChars) {
            for (int i = 0; i < expression.length(); i++) {
                if (!allowedChars.contains(expression.substring(i, i + 1))) {
                    return false;
                }
            }
            return true;
        }
    }


