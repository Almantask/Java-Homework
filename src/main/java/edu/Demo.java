package edu;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println(calculatePrice(20, "Standard", "Russia"));
    }

    private static double calculatePrice (double price, String vatKind, String country) {
        Scanner scanner = new Scanner(System.in);
        double taxRatio = 1;
        switch (country) {
            case "Austria":
                switch (vatKind) {
                    case "Standard":
                        taxRatio = 1.20;
                        break;
                    case "Reduced1":
                        taxRatio = 1.13;
                        break;
                    case "Reduced2":
                        taxRatio = 1.10;
                        break;
                    case "Zero":
                        taxRatio = 1.00;
                        break;
                }
                break;
            case "Belgium":
                switch (vatKind) {
                    case "Standard":
                        taxRatio = 1.21;
                        break;
                    case "Reduced1":
                        taxRatio = 1.12;
                        break;
                    case "Reduced2":
                        taxRatio = 1.06;
                        break;
                    case "Zero":
                        taxRatio = 1.00;
                        break;
                }
                break;
            case "Bulgaria":
                switch (vatKind) {
                    case "Standard":
                        taxRatio = 1.20;
                        break;
                    case "Reduced1":
                    case "Reduced2":
                    case "Reduced":
                        taxRatio = 1.09;
                        break;
                    case "Zero":
                        taxRatio = 1.00;
                        break;
                }
                break;
            case "Lithuania":
                switch (vatKind) {
                    case "Standard":
                        taxRatio = 1.21;
                        break;
                    case "Reduced1":
                        taxRatio = 1.09;
                        break;
                    case "Reduced2":
                        taxRatio = 1.05;
                        break;
                    case "Zero":
                        taxRatio = 1.00;
                        break;
                }
                break;
            default:
                System.out.println(country);
                switch (vatKind) {
                    case "Standard":
                    case "Reduced1":
                    case "Reduced2":
                    case "Zero":
                        System.out.println("Enter countries taxRatio percentage, because it isn't included in the list:");
                            taxRatio = scanner.nextDouble();
                }
                System.out.println("To add "+ country + ", you will have to do it manually");
        }
        return price * taxRatio;
    }
}
