package CookingConvertor;

public class CookingMeasurementConverter {

    public static CookingMeasurement convert (CookingMeasurement originalMeasurement, String Unit){
        float newAmount = 0;
        newAmount = Amounts.conversions(originalMeasurement, Unit);
        return new CookingMeasurement(newAmount, Unit);
    }
}
