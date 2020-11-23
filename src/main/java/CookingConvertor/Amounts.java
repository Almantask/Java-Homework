package CookingConvertor;

public enum Amounts {

    TSP(5f, "TSP"),
    ML(1f, "ML"),
    OZ (28f, "OZ"),
    POUND(454f, "POUND"),
    GALLON(3.8f, "GALLON"),
    QUART(0.95f, "QUART"),
    PINT(473f, "PINT"),
    CUP(237, "CUP"),
    FL_OUNCE(30f, "FL_OUNCE"),
    TBSP(15f, "TBSP");

    private float number;
    private String unitName;

    Amounts(float number, String unitName) {
        this.number = number;
        this.unitName = unitName;
    }

    public float getNumber() {
        return number;
    }

    public String getUnitName() {
        return unitName;
    }

    public static float value (String unit) {
        switch (unit) {
            case "TSP":
                return TSP.getNumber();
            case "ML":
                return ML.getNumber();
            case Cooking.Units.OZ:
                return OZ.getNumber();
            case "POUND":
                return POUND.getNumber();
            case "GALLON":
                return GALLON.getNumber();
            case "QUART":
                return QUART.getNumber();
            case "PINT":
                return PINT.getNumber();
            case "CUP":
                return CUP.getNumber();
            case "FL_OUNCE":
                return FL_OUNCE.getNumber();
            case "TBSP":
                return TBSP.getNumber();
            default:
                return ML.getNumber();
        }
    }

    public static float convertNumber(CookingConvertor.CookingMeasurement originalMeasurement, String unit) {
        float newAmount = (value(originalMeasurement.getUnit()) / value(unit)) * originalMeasurement.getAmount();
        return newAmount;
    }

    public static String[] values = {OZ.getUnitName(),POUND.getUnitName(),PINT.getUnitName(),GALLON.getUnitName(),
            QUART.getUnitName(),CUP.getUnitName(),FL_OUNCE.getUnitName(),TSP.getUnitName(),TBSP.getUnitName(),ML.getUnitName()};

    public static boolean isValid (String input) {
        for (String value : values) {
            if (input.toUpperCase().equals(value)) {
                return false;
            }
        }
        return true;
    }
}
