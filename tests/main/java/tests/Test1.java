package main.java.tests;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class Test1 {
    public static void main(String[] args) {
        int num1;
        int num2;
        int result;
        char smb;
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter first num  ");
        num1 = reader.nextInt();

        System.out.print("Enter smb ");
        smb = reader.next().charAt(0);

        System.out.print("Enter second num  ");
        num2 = reader.nextInt();

        switch(smb) {
            case '+'   : result = num1 + num2;
                break;
            case '-'   : result = num1 - num2;
                break;
            case '*'   : result = num1 * num2;
                break;
            case '/'   : result = num1 / num2;
                break;
            default:
                return;

        }
        System.out.println("\nResult is :\n" + num1 + " " + smb + " " + num2 + " = " + result);

    }

}

