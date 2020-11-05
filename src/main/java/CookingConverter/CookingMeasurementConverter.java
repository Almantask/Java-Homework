package CookingConverter;

import static CookingConverter.Cooking.Units.*;

public class CookingMeasurementConverter {
    private CookingMeasurementConverter() {
    }

    private static float getMeasurementRatio(String unit) {
        switch (unit) {
            case TSP:
                return Cooking.Amounts.TSP;
            case ML:
                return Cooking.Amounts.ML;
            case TBSP:
                return Cooking.Amounts.TBSP;
            case FL_OUNCE:
                return Cooking.Amounts.FL_OUNCE;
            case CUP:
                return Cooking.Amounts.CUP;
            case PINT:
                return Cooking.Amounts.PINT;
            case QUART:
                return Cooking.Amounts.QUART;
            case GALLON:
                return Cooking.Amounts.GALLON;
            case OZ:
                return Cooking.Amounts.OZ;
            case POUND:
                return Cooking.Amounts.POUND;
            case GRAMS:
                return Cooking.Amounts.GRAMS;
        }
        return 1F;
    }

    static CookingMeasurement convert(CookingMeasurement originalMeasurement, String unit) {
        return new CookingMeasurement(originalMeasurement.getAmount() / getMeasurementRatio(originalMeasurement.getUnit()) * getMeasurementRatio(unit), unit);
    }
}