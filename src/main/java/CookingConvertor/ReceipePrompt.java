package CookingConvertor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReceipePrompt {
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
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
                    System.out.println("For the recipe processing to work on multiple ingredients you have to write in syntax 'ingredient amount unit' and repeat in the same order till your done");
                    recipeFromStringConverter();
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
        System.out.println("Enter ingredient, amount and unit: ");
        String input = scanner.nextLine();
        String [] measurements = input.split(" ");
        for (int i = 0; i < measurements.length; i++) {
            if (checkIfANumber(measurements[i])) {
                float number = Float.parseFloat(measurements[i++]);
                if (!Cooking.Units.isValid(measurements[i])) {
                    CookingMeasurement calculated = CookingMeasurementConverter.convert(new CookingMeasurement(number, measurements[i].toUpperCase()), "ML");
                    System.out.println(" Amount: " + calculated.getAmount() + " ML");
                }
            }
            if (!checkIfANumber(measurements[i]) && Cooking.Units.isValid(measurements[i])) {
                String component = measurements[i];
                System.out.println(component);
            }
        }
    }

    private boolean checkIfANumber (String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void cookingMeasurementConverter () {
        float amount = promptAmount();
        String fromUnit = promptUnit();
        String toUnit = promptUnit1();
        CookingMeasurement calculated = CookingMeasurementConverter.convert(new CookingMeasurement(amount, fromUnit.toUpperCase()),toUnit);
        System.out.println("Amount = " + calculated.getAmount() + "\nUnit from which converted: " + fromUnit.toUpperCase() + "\nConverted to: " + toUnit.toUpperCase());
    }

    private float promptAmount() {
        System.out.println("Enter amount of unit:");
        while (true) {
            try {
                float amount = scanner.nextFloat();
                if (amount < 0) {
                    return 0;
                }
                return amount;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Enter number from 0 to 9.");
            }
        }
    }

    private String promptUnit() {
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

