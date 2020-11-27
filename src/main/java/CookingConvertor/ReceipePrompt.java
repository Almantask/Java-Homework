package CookingConvertor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReceipePrompt {
    public static final Scanner scanner = new Scanner(System.in);

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
                    System.out.println("Enter ingredient amount and unit no matter the sequence");
                    recipeFromStringConverter();
                    break;
                case 3:
                    recipeFromFile();
                    break;
                case 4:
                    quit = true;
                    break;
                case 5:
                    displayMenu();
                    break;

            }
        }
    }

    public void recipeFromFile (){
        ArrayList<String> recipe = new ArrayList<>();
        File file = new File("recipe.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()) {
                recipe.add(sc.next());
            }
            for (int i = 0; i < returnAllIngredientNames(recipe).size(); i++) {
                System.out.println("Ingredient " + returnAllIngredientNames(recipe).get(i)
                        + " amount " + returnAllNumbers(recipe).get(i)
                        + " unit " + returnAllUnits(recipe).get(i));
            }
            } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void recipeFromStringConverter () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredient, amount and unit: ");
        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            String[] measurements = input.split(" ");
            List<String> measurementsInList;
            measurementsInList = Arrays.asList(measurements);
            for (int i = 0; i < returnAllIngredientNames(measurementsInList).size(); i++) {
                System.out.println("Ingredient " + returnAllIngredientNames(measurementsInList).get(i)
                        + " amount " + returnAllNumbers(measurementsInList).get(i)
                        + " unit " + returnAllUnits(measurementsInList).get(i));
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
                "[3] - recipe processing from file\n" +
                "[4] - quit program\n" +
                "[5] - print menu");
    }

    public List<String> returnAllIngredientNames (List<String> array) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : array) {
            if (!checkIfANumber(s) && Cooking.Units.isValid(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }

    public List<String> returnAllNumbers (List<String> array) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : array) {
            if (checkIfANumber(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }

    public List<String> returnAllUnits (List<String> array) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : array) {
            if (!Cooking.Units.isValid(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }


}

