package CookingConvertor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReceipePrompt {

    private String receipe;

    public void run() {
        menu();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("Choose action");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    cookingMeasurementConverter();
                    break;
                case 2:
                    recipeFromStringConverter();
                    break;
                case 3:
                    recipeFromFile();
                    break;
                case 4:
                    quit = true;
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        }
    }

    public void menu() {

        System.out.println("[1] - basic conversion of a measurement\n" +
                "[2] - recipe processing from string\n" +
                "[3] - recipe processing from file\n" +
                "[4] - quit program\n" +
                "[5] - print menu");
    }

    private float promptAmount() {
        Scanner amountIN = new Scanner(System.in);
        System.out.println("Please enter amount of unit: ");
        while (true) {
            try {
                float amount = amountIN.nextFloat();
                if (amount <= 0) {
                    throw new InvalidDataException();
                }
                return amount;
            } catch (InvalidDataException e) {
                System.out.println("The number you entered is invalid! " + e.getMessage());
            }
        }
    }

    private String promptUnit() {
        Scanner unitIN = new Scanner(System.in);
        System.out.println("Please enter unit that you want to convert: ");
        String unit = unitIN.nextLine();
        if (!Amounts.Validation(unit.toUpperCase())) {
            while (!Amounts.Validation(unit.toUpperCase())) {
                System.out.println("The unit you entered does not exist, please try again: ");
                unit = unitIN.nextLine();
            }
        }
        return unit;
    }

    private String promptUnitTo() {
        Scanner unitOut = new Scanner(System.in);
        System.out.println("Please enter unit that you want to convert to: ");
        String unit = unitOut.nextLine();
        if (!Amounts.Validation(unit.toUpperCase())) {
            while (!Amounts.Validation(unit.toUpperCase())) {
                System.out.println("The unit you entered does not exist, please try again: ");
                unit = unitOut.nextLine();
            }
        }
        return unit;
    }

    private void cookingMeasurementConverter() {
        float amount = promptAmount();
        String fromUnit = promptUnit();
        String toUnit = promptUnitTo();
        CookingMeasurement converted = CookingMeasurementConverter.convert(new CookingMeasurement(amount, fromUnit.toUpperCase()), toUnit.toUpperCase());
        System.out.printf("%s %s is equal to %s %s", amount, fromUnit.toUpperCase(), converted.getAmount(), toUnit.toUpperCase());
    }

    public void recipeFromStringConverter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter recipe: ");
        receipe = scanner.nextLine();
        String[] receipeWords = receipe.split(" ");
        for (int i = 0; i < receipeWords.length - 1; i++) {
            if (receipeWords[i].matches("[0-9]") && Amounts.Validation(receipeWords[i + 1].toUpperCase())) {
                CookingMeasurement knownMeasurement = new CookingMeasurement(Float.parseFloat(receipeWords[i]), receipeWords[i + 1].toUpperCase());
                knownMeasurement = CookingMeasurementConverter.convert(knownMeasurement, "ML");
                receipeWords[i] = Float.toString(knownMeasurement.getAmount());
                receipeWords[i + 1] = knownMeasurement.getUnit();
            }
        }
        receipe = String.join(" ", receipeWords);
        System.out.println(receipe);
    }

    public void recipeFromFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String file = scanner.nextLine();
        File recipe = new File(file);
        try {
            Scanner myReader = new Scanner(recipe);
            while (myReader.hasNextLine()){
                receipe = myReader.nextLine();
                String[] receipeWords = receipe.split(" ");
                for (int i = 0; i < receipeWords.length - 1; i++) {
                    if (receipeWords[i].matches("[0-9]") && Amounts.Validation(receipeWords[i + 1].toUpperCase())) {
                        CookingMeasurement knownMeasurement = new CookingMeasurement(Float.parseFloat(receipeWords[i]), receipeWords[i + 1].toUpperCase());
                        knownMeasurement = CookingMeasurementConverter.convert(knownMeasurement, "ML");
                        receipeWords[i] = Float.toString(knownMeasurement.getAmount());
                        receipeWords[i + 1] = knownMeasurement.getUnit();
                    }
                }
                receipe = String.join(" ", receipeWords);
                System.out.println(receipe);
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
