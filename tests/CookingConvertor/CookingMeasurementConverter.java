package CookingConvertor;

public class CookingMeasurementConverter {

    public static CookingMeasurement convert(CookingMeasurement originalMeasurement,String unit) {
        float newAmount = Cooking.Amounts.switching(originalMeasurement,unit);
        return new CookingMeasurement(newAmount, unit);
    }

}

