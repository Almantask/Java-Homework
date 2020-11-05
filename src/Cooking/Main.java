package Cooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReceipePrompt rp = new ReceipePrompt();
        rp.run();
/*

        CookingMeasurement cm = new CookingMeasurement(amount, unit);
        cm = CookingMeasurementConverter.convert(cm, Cooking.Units.ML);
        System.out.printf("%s %s = %s %s", amount, unit, cm.getAmount(),cm.getUnit());*/
    }

}
