package edvinas;

class Calculator{
    public static void main(String[] args) {

        System.out.println(addition("5!"));
//        System.out.println(factorial(5));

    }

    public static int addition(String input) {
        if (empty(input)) {
            return 0;
        }

        String operators[] = input.split("[0-9]");
        String operands[] = input.split("[*+-/!]");
        int action = Integer.parseInt(operands[0]);
        int o = 1;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals("+")) {
                action += Integer.parseInt(operands[o++]);
            }
            else if (operators[i].equals("-")) {
                action -= Integer.parseInt(operands[o++]);
            }
            else if (operators[i].equals("*")) {
                action *= Integer.parseInt(operands[o++]);
            }
            else if (operators[i].equals("/")) {
                action /= Integer.parseInt(operands[o++]);
            }
            else if (operators[i].equals("!")) {
                action = factorial(action);
                o++;
            }

        }
        return action;
    }

    private static boolean empty(String string) {
        if (string.isEmpty()) {
            return true;
        }
        return false;
    }

    public static int factorial (int number) {
        int factorial = 1;
        for (int i = 1; i < number+1; i++) {
            factorial *= i;
        }
        return factorial;
    }
}