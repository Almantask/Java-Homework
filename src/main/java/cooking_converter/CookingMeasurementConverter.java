package cooking_converter;

public class CookingMeasurementConverter {
    private CookingMeasurementConverter() {
    }

    public static CookingMeasurement convert(CookingMeasurement originalMeasurement, EUnits unit) {
        return new CookingMeasurement(originalMeasurement.getAmount() / originalMeasurement.getUnit().getAmount() * unit.getAmount(), unit);
    }
}