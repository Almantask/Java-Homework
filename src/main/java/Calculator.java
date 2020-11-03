// It's 1949 and you are tasked to lead programmer's team in order to implement a brand new calculator. The calculator is very simple though: it can add (+), multiple(x), divide(%) and take(-). It does not and will not support any brackets or memory. It will only ever support whole numbers.
// Calculator should have only 1 function- int calculate(string expression)

public class Calculator {

    private char[] defaultOperators = {'+', '-', 'x', '%', '/', '!'};
    private char[] charArray;


    public int calculate (String expression) {

        // empty string should return 0
        if (expression == "" || expression.isEmpty()){
            return 0;
        }
        // 3 - Division from 0
        // Division from zero should not be possible. If a string "5/0" is passed, result should be -1
        if (expression.contains("/0")) {
            return -1;
        }
        // 4 - Floating point numbers
        // Floating point numbers should not be supported. If string contains not a whole number and not the allowed operations (+-x%) then it should also return -1.
        if (expression.contains(".") || !hasOnlyAllowedChars(expression, "0123456789+-*/%!")) {
            return -1;
        }
        charArray = expression.toCharArray();
        int result = Integer.parseInt(String.valueOf(charArray[0]));
        for (int i = 1; i < charArray.length; i = i + 2 ) {
            if ((i + 1) != charArray.length) {
                result = calculation(result, charArray[i], Integer.parseInt(String.valueOf(charArray[i + 1])));

            } else result = calculation(result, charArray[i], 0);
        }
        return result;
    }
    private Integer calculation(int part1, char operator, int part2){
        switch (operator){
            case '+':
                return part1 + part2;
            case '-':
                return part1 - part2;
            case '*':
                return part1 * part2;
            case '%':
                return part1 % part2;
            case '/':
                if (part2 == 0){
                    return -1;
                } return part1 / part2;
            case '!':
                return factorial(part1);
            default:
                return null;
        }
    }
    //5 - Factorial
    //Factorial is a number that is being multiplied from 1, till itself and is marked using "!".
    private int factorial(int part1) {
        int result = part1;
        for (int i = part1 - 1; i > 0; i--) {
            result = result * i;
        }
        return result;
    }
    private static boolean hasOnlyAllowedChars(String expression, String allowedChars){
        for (int i = 0; i < expression.length(); i++){
            if(!allowedChars.contains(expression.substring(i, i+1))){
                return false;
            }
        }
        return true;
    }
}