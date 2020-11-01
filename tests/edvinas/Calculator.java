package edvinas;

class Calculator{
    public static void main(String[] args) {

        System.out.println(calculator("5+5") + factorial(5));

//        System.out.println(factorial(5));

    }

    public static int calculator(String input) {
        if (input.isEmpty() || input.contains(",")) {
            return 0;
        } else {
            String operators[] = input.split("[0-9]");
            printArray(operators);
            String operands[] = input.split("[*+-/!]");
            printArray(operands);
            int action = Integer.parseInt(operands[0]);
            int factorial = Integer.parseInt(operands[0]);
            int o = 1;
            for (int i = 0; i < operators.length; i++) {
                if (operators[i].equals("+")) {
                    action += Integer.parseInt(operands[o++]);
                } else if (operators[i].equals("-")) {
                    action -= Integer.parseInt(operands[o++]);
                } else if (operators[i].equals("*")) {
                    action *= Integer.parseInt(operands[o++]);
                } else if (operators[i].equals("/")) {
                    action /= Integer.parseInt(operands[o++]);
                } else if (operators[i].equals("!")) {
                    factorial = factorial(factorial);
                    action = factorial;
                }

            }
            return action;
        }
    }
    public static int factorial (int number) {
        int factorial = 1;
        for (int i = 1; i < number+1; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void printArray (String [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }



}