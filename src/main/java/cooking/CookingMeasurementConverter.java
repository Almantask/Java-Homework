package cooking;

public class CookingMeasurementConverter {

    public static CookingMeasurement convert(CookingMeasurement originalMeasurement, String unit) {
        float result = 0;
        if (originalMeasurement.getUnit().equals("ML")) {
            result = originalMeasurement.getAmount() * 1;
        }
        if (originalMeasurement.getUnit().equals("TSP")) {
            result = originalMeasurement.getAmount() * 5;
        }
        if (originalMeasurement.getUnit().equals("OZ")) {
            result = originalMeasurement.getAmount() * 28;
        }
        if (originalMeasurement.getUnit().equals("TBSP")) {
            result = originalMeasurement.getAmount() * 15;
        }
        if (originalMeasurement.getUnit().equals("FL_OUNCE")) {
            result = originalMeasurement.getAmount() * 30;
        }
        if (originalMeasurement.getUnit().equals("CUP")) {
            result = originalMeasurement.getAmount() * 237;
        }
        if (originalMeasurement.getUnit().equals("PINT")) {
            result = originalMeasurement.getAmount() * 437;
        }
        if (originalMeasurement.getUnit().equals("QUART")) {
            result = originalMeasurement.getAmount() * 950;
        }
        if (originalMeasurement.getUnit().equals("GALLON")) {
            result = originalMeasurement.getAmount() * 38000;
        }
        if (originalMeasurement.getUnit().equals("POUND")) {
            result = originalMeasurement.getAmount() * 454;
        }


        return new CookingMeasurement(result, "ML");

    }
}
