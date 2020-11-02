package CookingConvertor;

public class CookingMeasurementConverter {

    public static CookingMeasurement convert (CookingMeasurement originalMeasurement) {
        float newAmount = 0;
        switch (originalMeasurement.getUnit().toUpperCase()) {
            case "TSP":
                System.out.println("Converted from TSP");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getTSP();
                break;
            case "OZ":
                System.out.println("Converted from OZ");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getOZ();
                break;
            case "POUND":
                System.out.println("Converted from Pounds");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getPOUND();
                break;
            case "QUART":
                System.out.println("Converted from Quart");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getQUART();
                break;
            case "GALLON":
                System.out.println("Converted from Gallon");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getGALLON();
                break;
            case "PINT":
                System.out.println("Converted from Pint");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getPINT();
                break;
            case "CUP":
                System.out.println("Converted from Cup");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getCUP();
                break;
            case "FL_OUNCE":
                System.out.println("Converted from FL_OUNCE");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getFlOunce();
                break;
            case "TBSP":
                System.out.println("Converted from TBSP");
                newAmount = originalMeasurement.getAmount() * Cooking.Amounts.getTBSP();
                break;
            default:
                System.out.println("Enter again");
        }
        return new CookingMeasurement(newAmount, "ML");
    }
}

