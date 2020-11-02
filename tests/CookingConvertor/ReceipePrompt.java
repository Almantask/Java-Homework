package CookingConvertor;

import java.util.Scanner;

public class ReceipePrompt {


    public void run() {
        Scanner scanner = new Scanner(System.in);

        menu();
        boolean quit =false;

        while (!quit) {

            System.out.println("Enter number from menu" +
                    "(To print menu again enter [4]):");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    float amount = promptAmount();
                    String fromUnit = promptUnit();
                    String toUnit = promptUnit1();
                    CookingMeasurement calculated = CookingMeasurementConverter.convert(new CookingMeasurement(amount, fromUnit.toUpperCase()),toUnit);
                    System.out.println("Amount = " + calculated.getAmount() + "\nUnit from which converted: " + fromUnit.toUpperCase() + "\nConverted to: " + toUnit.toUpperCase());
                    break;
                case 2:
                    String TEXT_RED = "\u001B[31m";
                    String TEXT_RESET = "\u001B[0m";
                    System.out.println(TEXT_RED + "To be implemented!" + TEXT_RESET);
                    break;
                case 3:
                    quit = true;
                    break;
                case 4:
                    menu();
                    break;
            }
        }
    }

    private float promptAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of unit:");
            float amount = scanner.nextFloat();
        return amount;
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

    private void menu () {
        System.out.println("Menu");
        System.out.println("[1] - basic conversion of a measurement\n" +
                "[2] - recipe processing\n" +
                "[3] - quit program\n" +
                "[4] - print menu");
    }
}

