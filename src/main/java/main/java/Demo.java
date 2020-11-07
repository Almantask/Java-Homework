package main.java;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args){


        boolean repeat = true;

        while (repeat) {

            Scanner scan = new Scanner(System.in);
            Scanner stringScan = new Scanner(System.in);

            System.out.println("Enter first number: ");
            int num1 = scan.nextInt();

            System.out.println("Choose action: + - / * ");
            char action = scan.next().charAt(0);

            System.out.println("Enter second number: ");
            int num2 = scan.nextInt();



            int result = calculation(action,num1,num2);
            System.out.println("Result is: " + result);

            System.out.println("Do you want to repeat? YES / NO ");
            String userAnswer = stringScan.nextLine();

            if(userAnswer.equalsIgnoreCase("no")){
                repeat = false;
            }



        }


    }

    static int calculation(char action, int first, int second) {
        switch (action) {
            case '+': {
                return first + second;
            }
            case '-' : {
                return first - second;
            }
            case '/' : {
                return first / second;
            }
            case '*' : {
                return first * second;
            }
            default: {
                System.out.println("Action not found!");
                return 0;
            }
        }
    }


}
