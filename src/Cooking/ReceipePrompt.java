package Cooking;

import java.util.Scanner;

public class ReceipePrompt {
    private int menuOption;
    private float amount;
    private String unit;
    private String toUnit;
    private String receipe;

    public void run(){
        menu();
        if (menuOption == 1) {
            basicConvertionOfMeasurement();
        } else if (menuOption == 2){
            //System.out.println("\u001B[31mTo be implemented...");
            receipeProcessing();
        }
    }

    private void menu(){
        System.out.println("1 - basic conversion of a measurement\n2 - receipe processing");
        Scanner input = new Scanner(System.in);
        menuOption = input.nextInt();
        while (menuOption != 1 && menuOption != 2){
            System.out.println("Selected not 1 or 2. select Menu again:");
            menuOption = input.nextInt();//I don't know how to read whole text.
        }
    }

    private void basicConvertionOfMeasurement() {
        promptAmount();
        promptUnit();
        promptToUnit();
        CookingMeasurement CMInput = new CookingMeasurement(amount, unit);
        CMInput = CookingMeasurementConverter.convert(CMInput, toUnit);
        System.out.printf("\u001B[31m%s %s = %s %s", amount, unit, CMInput.getAmount(),CMInput.getUnit());
    }

    private void receipeProcessing(){
        prompReceipe();
        String [] recipeWords = receipe.split(" ");
        for (int i = 0; i < recipeWords.length-1; i++){
            if (recipeWords[i].matches("[0-9]") && Cooking.Units.unitExists(recipeWords[i+1])){
                CookingMeasurement CMInput = new CookingMeasurement(Float.parseFloat(recipeWords[i]), recipeWords[i+1]);
                CMInput = CookingMeasurementConverter.convert(CMInput, Cooking.Units.ML);
                recipeWords[i] = Float.toString(CMInput.getAmount());
                recipeWords[i+1] = CMInput.getUnit();
            }
        }
        receipe = String.join(" ", recipeWords);
        System.out.println(receipe);
    }

    private void prompReceipe() {
        System.out.println("Enter receipe:");
        Scanner input = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        receipe = input.nextLine();
    }

    private void promptAmount(){
        System.out.println("Enter amount:");
        Scanner input = new Scanner(System.in);
        amount = input.nextFloat();
        while (amount <= 0){
            System.out.println("Entered amount is negative or zero. Enter amount again:");
            amount = input.nextFloat();
        }
    }

    private void promptUnit(){
        System.out.println("Enter unit:");
        Scanner input = new Scanner(System.in);
        unit = input.next().toUpperCase();
        while (!Cooking.Units.unitExists(unit)){
            System.out.println("Entered invalid unit. Enter unit again:");
            unit = input.next().toUpperCase();
        }
    }

    private void promptToUnit(){
        System.out.println("Enter unit to convert to:");
        Scanner input = new Scanner(System.in);
        toUnit = input.next().toUpperCase();
        while (!Cooking.Units.unitExists(unit)){
            System.out.println("Entered invalid unit. Enter unit to convert to again:");
            toUnit = input.next().toUpperCase();
        }
    }
}
