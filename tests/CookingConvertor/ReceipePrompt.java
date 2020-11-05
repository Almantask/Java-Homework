package CookingConvertor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReceipePrompt {


    public void run() {
        Scanner scanner = new Scanner(System.in);

        displayMenu();
        boolean quit =false;

        while (!quit) {

            System.out.println("Enter number from menu" +
                    "(To print menu again enter [4]):");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    cookingMeasurementConverter();
                    break;
                case 2:
                    recipeConverter();
                    break;
                case 3:
                    quit = true;
                    break;
                case 4:
                    displayMenu();
                    break;
            }
        }
    }

    public void recipeFromStringConverter () {
    Scanner scanner = new Scanner(System.in);
        String input = "Sugar 10 tsp Rice 2 tsp milk 1 tsp water 2 Oz";

        String [] measurements = input.split(" ");

        for (int i = 0; i < measurements.length; i++) {

            if (checkIfANumber(measurements[i])) {

                float number = Float.parseFloat(measurements[i++]);

                if (Cooking.Units.isValid(measurements[i])) {

                        CookingMeasurement calculated = CookingMeasurementConverter.convert(new CookingMeasurement(number, measurements[i].toUpperCase()), "ML");
                        System.out.println(" Amount: " + calculated.getAmount() + " ML");


                }

            }
            if (!checkIfANumber(measurements[i]) && !Cooking.Units.isValid(measurements[i])) {
                String component = measurements[i];
                System.out.println(component);
            }

        }


    }

    private boolean checkIfANumber (String s) {
               try {
                   float number = Float.parseFloat(s);
                   return true;
               } catch (NumberFormatException e) {
                   return false;
               }
        }



    private void recipeConverter() {
        String TEXT_RED = "\u001B[31m";
        String TEXT_RESET = "\u001B[0m";
        System.out.println(TEXT_RED + "To be implemented!" + TEXT_RESET);
    }


    private void cookingMeasurementConverter () {
        float amount = promptAmount();
        String fromUnit = promptUnit();
        String toUnit = promptUnit1();
        CookingMeasurement calculated = CookingMeasurementConverter.convert(new CookingMeasurement(amount, fromUnit.toUpperCase()),toUnit);
        System.out.println("Amount = " + calculated.getAmount() + "\nUnit from which converted: " + fromUnit.toUpperCase() + "\nConverted to: " + toUnit.toUpperCase());
    }

    private float promptAmount() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter amount of unit:");
            float amount = scanner.nextFloat();
            return amount;
        } catch (InputMismatchException e) {
            System.out.println("You need to enter number!!!");
        }
        return -1;
    }

    private String promptUnit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter unit:");
        String unit = scanner.nextLine();
        if (Cooking.Units.isValid(unit)) {
            while (Cooking.Units.isValid(unit)) {
                System.out.println("Enter unit again, because previous doesn't exist:");
                unit = scanner.nextLine();
            }
        }
        return unit;
    }

    private String promptUnit1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter unit to which you want to convert:");
        String unit = scanner.nextLine();
        if (Cooking.Units.isValid(unit)) {
            while (Cooking.Units.isValid(unit)) {
                System.out.println("Enter unit again, because previous doesn't exist:");
                unit = scanner.nextLine();
            }
        }
        return unit;
    }

    private void displayMenu () {
        System.out.println("Menu");
        System.out.println("[1] - basic conversion of a measurement\n" +
                "[2] - recipe processing\n" +
                "[3] - quit program\n" +
                "[4] - print menu");
    }
}

