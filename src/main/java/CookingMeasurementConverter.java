public class CookingMeasurementConverter {


    public static CookingMeasurement convert(CookingMeasurement originalMeasurement, String unit) {

        return new CookingMeasurement(originalMeasurement.getAmount() *  ratio(originalMeasurement.getUnit(),unit), unit);)
    }

    private static float ratio(String fromUnit, String toUnit){
        float fromUnitAmount = 0;
        float toUnitAmount = 0;
        for (int i = 0; i < Cooking.Units.getValues().length; i++){
            if (Cooking.Units.getValues()[i].equals(fromUnit)){
                fromUnitAmount = Cooking.Amounts.getValues()[i];
            }
            if (Cooking.Units.getValues()[i].equals(toUnit)){
                toUnitAmount = Cooking.Amounts.getValues()[i];
            }
        }
        return fromUnitAmount/toUnitAmount;
    }
}



