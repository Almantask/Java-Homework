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
            case Cooking.Units.TSP:
                return TSP.getNumber();
            case Cooking.Units.ML:
                return ML.getNumber();
            case Cooking.Units.OZ:
                return OZ.getNumber();
            case Cooking.Units.POUND:
                return POUND.getNumber();
            case Cooking.Units.GALLON:
                return GALLON.getNumber();
            case Cooking.Units.QUART:
                return QUART.getNumber();
            case Cooking.Units.PINT:
                return PINT.getNumber();
            case Cooking.Units.CUP:
                return CUP.getNumber();
            case Cooking.Units.FL_OUNCE:
                return FL_OUNCE.getNumber();
            case Cooking.Units.TBSP:
                return TBSP.getNumber();
            default:
                return ML.getNumber();
        }
    }

    public static float switching(CookingConvertor.CookingMeasurement originalMeasurement, String unit) {
        float newAmount = 0;
        switch (unit.toUpperCase()) {
            case "TSP":
                newAmount = (value(originalMeasurement.getUnit()) / TSP.getNumber()) * originalMeasurement.getAmount();
                break;
            case "OZ":
                newAmount = (value(originalMeasurement.getUnit()) / OZ.getNumber()) * originalMeasurement.getAmount();
                break;
            case "POUND":
                newAmount = (value(originalMeasurement.getUnit()) / POUND.getNumber()) * originalMeasurement.getAmount();
                break;
            case "QUART":
                newAmount = (value(originalMeasurement.getUnit()) / QUART.getNumber()) * originalMeasurement.getAmount();
                break;
            case "GALLON":
                newAmount = (value(originalMeasurement.getUnit()) / GALLON.getNumber()) * originalMeasurement.getAmount();
                break;
            case "PINT":
                newAmount = (value(originalMeasurement.getUnit()) / PINT.getNumber()) * originalMeasurement.getAmount();
                break;
            case "CUP":
                newAmount = (value(originalMeasurement.getUnit()) / CUP.getNumber()) * originalMeasurement.getAmount();
                break;
            case "FL_OUNCE":
                newAmount = (value(originalMeasurement.getUnit()) / FL_OUNCE.getNumber()) * originalMeasurement.getAmount();
                break;
            case "TBSP":
                newAmount = (value(originalMeasurement.getUnit()) / TBSP.getNumber()) * originalMeasurement.getAmount();
                break;
            case "ML":
                newAmount = (value(originalMeasurement.getUnit()) / ML.getNumber()) * originalMeasurement.getAmount();
                break;
            default:
                System.out.println("Enter again");
        }
        return newAmount;
    }
}
