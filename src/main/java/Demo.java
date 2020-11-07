package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        calculator1();
    }

    public static void calculator1() {
        Scanner sc = new Scanner(System.in);
        String inputString;
        System.out.println("Enter a string :");
        inputString = sc.nextLine();

//        char a -inputString.charAt(1)
//        if (inputString.charAt(1) == "a") {
//        }

        String[] ary = inputString.split("");
        System.out.println(Arrays.toString(ary));
        int c = 1;
        int a;
        int b;
        for (int i = 1; i < ary.length; i = i + 2) {
            switch (ary[i]) {
                case "!" -> {
                    System.out.println(Integer.parseInt(ary[i - 1]));
                    a = Integer.parseInt(ary[i - 1]);
                    System.out.println(a);
                    while (a > 0) {
                        c *= a;
                        a--;
                    }
                }
                case "*" -> {
                    a = Integer.parseInt(ary[i - 1]);
                    b = Integer.parseInt(ary[i + 1]);
                    c = a * b;
                    break;
                }
                case "/" -> {
                    a = Integer.parseInt(ary[i - 1]);
                    b = Integer.parseInt(ary[i + 1]);
                    c = a / b;
                    break;
                }
                case "+" -> {
                    a = Integer.parseInt(ary[i - 1]);
                    b = Integer.parseInt(ary[i + 1]);
                    c = a + b;
                    break;
                }
                case "-" -> {
                    a = Integer.parseInt(ary[i - 1]);
                    b = Integer.parseInt(ary[i + 1]);
                    c = a - b;
                    break;
                }
            }
            System.out.println(c);
        }
    }}
