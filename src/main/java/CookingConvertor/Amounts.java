package CookingConvertor;

public enum Amounts {

    TSP(5f),
    ML(1f),
    OZ (28f),
    POUND(454f),
    GALLON(3.8f),
    QUART(0.95f),
    PINT(473f),
    CUP(237),
    FL_OUNCE(30f),
    TBSP(15f);

    private final float number;

    Amounts(float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    public static float value (String unit) {
        switch (unit) {
            case "TSP":
                return TSP.getNumber();
            case "ML":
                return ML.getNumber();
            case "OZ":
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
                return 0;
        }
    }
    public static String[] values = {OZ.name(),POUND.name(),PINT.name(),GALLON.name(),QUART.name(),CUP.name(),FL_OUNCE.name(),TSP.name(),TBSP.name(),ML.name()};

    public static boolean isValid (String input) {
        for (String value : values) {
            if (input.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static float convertNumber(CookingMeasurement originalMeasurement, String unit) {
        return (value(originalMeasurement.getUnit()) / value(unit)) * originalMeasurement.getAmount();
    }

}
