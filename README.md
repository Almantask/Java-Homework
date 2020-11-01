import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter num1: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter num2: ");
        int num2 = scanner.nextInt();


        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

       int result = 0;

        switch(operator)
        {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 !=0) {
                    result = num1 / num2;
                } else {
                    result = -1;
                }
                break;

        }

        System.out.println(result);

    }
}
