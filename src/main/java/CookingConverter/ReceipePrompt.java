package CookingConverter;

import java.util.Scanner;

public class ReceipePrompt {
    private float amount;
    private String unitFrom;
    private String unitTo;
    private boolean isUnitVolume;

    public void run() {
        promptAmount();
        promptUnitFrom();
        promptUnitTo();
    }

    private void promptAmount() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter amount: ");
                String input = scanner.nextLine();
                float amount = Float.parseFloat(input);
                if (amount < 0) {
                    System.out.println("ERROR! Amount can't be negative. Please enter valid amount.");
                } else {
                    this.amount = amount;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Invalid number. Please enter valid number.");
            }
        }
    }

    private void promptUnitFrom() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter unit from: ");
            String input = scanner.nextLine().toUpperCase();
            if (!Cooking.Units.isValid(input)) {
                System.out.println("ERROR! Unit isn't valid. Please enter valid unit." + Cooking.Units.getValues());
            } else {
                this.unitFrom = input;
                this.isUnitVolume = Cooking.Units.getVolumeValues().contains(input);
                break;
            }
        }
    }

    private void promptUnitTo() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter unit to: ");
            String input = scanner.nextLine().toUpperCase();
            if (!Cooking.Units.isValid(input)) {
                System.out.println("ERROR! Unit isn't valid. Please enter valid unit." + Cooking.Units.getValues());
            } else {
                if (isUnitVolume) {
                    if (Cooking.Units.getVolumeValues().contains(input)) {
                        this.unitTo = input;
                        break;
                    } else {
                        System.out.println("ERROR! Unit isn't volume unit. Please enter volume units." + Cooking.Units.getVolumeValues());
                    }
                } else {
                    if (Cooking.Units.getWeightValues().contains(input)) {
                        this.unitTo = input;
                        break;
                    } else {
                        System.out.println("ERROR! Unit isn't weight unit. Please enter weight units." + Cooking.Units.getWeightValues());
                    }
                }
            }
        }
    }

    public String getUnitTo() {
        return this.unitTo;
    }

    public CookingMeasurement getMeasurementFrom() {
        return new CookingMeasurement(this.amount, this.unitFrom);
    }
}