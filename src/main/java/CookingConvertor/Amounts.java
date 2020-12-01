package CookingConvertor;

public enum Amounts {
    ML(1),
    TSP(5),
    TBSP(15),
    FL_OUNCE(30),
    CUP(237),
    PINT(473),
    QUART(950),
    GALLON(3800),
    OZ(28),
    POUND(454);

    private final float ml;

    Amounts(float ml) {
       this.ml = ml;
    }

    public float getMl() {
        return ml;
    }
    public static float value (String unit){
    switch(unit) {
        case "ML":
            return ML.getMl();
        case "TSP":
            return TSP.getMl();
        case "TBSP":
            return TBSP.getMl();
        case "FL_OUNCE":
            return FL_OUNCE.getMl();
        case "CUP":
            return CUP.getMl();
        case "PINT":
            return PINT.getMl();
        case "QUART":
            return QUART.getMl();
        case "GALLON":
            return GALLON.getMl();
        case "OZ":
            return OZ.getMl();
        case "POUND":
            return POUND.getMl();
        default:
            return 0;
        }
    }
    public static String[] Values = {ML.name(), TSP.name(), TBSP.name(), FL_OUNCE.name(), CUP.name(), PINT.name(), QUART.name(), GALLON.name(), OZ.name(), POUND.name()};

    public static boolean Validation(String input){
        for (String value : Values) {
            if (input.equals(value)){
                return true;
            }
        }
        return false;
    }
    public static float conversions(CookingMeasurement cookingMeasurement, String Unit){
        return value(cookingMeasurement.getUnit()) / value(Unit) * cookingMeasurement.getAmount();
    }

}
