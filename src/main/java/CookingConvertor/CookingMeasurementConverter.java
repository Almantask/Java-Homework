package CookingConvertor;

public class CookingMeasurementConverter {

    public static CookingConvertor.CookingMeasurement convert(CookingConvertor.CookingMeasurement originalMeasurement, String unit) {
        float newAmount = Amounts.convertNumber(originalMeasurement,unit);
        return new CookingConvertor.CookingMeasurement(newAmount, unit);
    }

}