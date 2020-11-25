package CookingConvertor;

public class CookingMeasurementConverter {

    public static CookingConvertor.CookingMeasurement convert(CookingConvertor.CookingMeasurement originalMeasurement, String unit) {
        float newAmount;
        if (originalMeasurement.getAmount() < 0) {
            newAmount = 0;
            return new CookingConvertor.CookingMeasurement(newAmount, unit);
        }
        newAmount = Amounts.convertNumber(originalMeasurement,unit);
        return new CookingConvertor.CookingMeasurement(newAmount, unit);

    }

}