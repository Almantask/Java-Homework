package edu;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThousandsSeparator separator = new ThousandsSeparator(scanner.nextLong());
    }
}
