public class Cooking {

    static class Units {
        public static final String OZ;
        public static final String POUND;
        public static final String GALLON;
        public static final String QUART;
        public static final String PINT;
        public static final String CUP;
        public static final String FL_OUNCE;
        public static final String TBSP;
        public static final String TSP;
    }

    String[] getValues(String OZ, String POUND, String GALLON, String QUART, String PINT, String CUP, String FL_OUNCE, String TBSP, String TSP) {
    if (OZ != null) {
        return OZ;
        }
    if (POUND != null) {
        return;
        }
    if (GALLON != null) {
        return;
        }
    if (QUART != null) {
        return;
        }
    if (PINT != null) {
        return;
        }
    if (CUP != null) {
        return;
        }
    if (FL_OUNCE != null) {
        return;
    }
    if (TBSP != null) {
        return;
    }
    if (TSP != null) {
        return;
    }

    static class Amounts {
        public static final float TSP = 5;
        public static final float ML = 1;
        public static final float TBSP = 15;
        public static final float FL_OUNCE = 30;
        public static final float CUP = 237;
        public static final float PINT = 473;
        public static final float QUART = 950;
        public static final float GALLON = 3800;
        public static final float OZ = 28;
        public static final float POUND = 454;

        switch (Amounts) {
            case "ML":
                Units = ML;
            case "TSP":
                Units = TSP;
                break;
            case "TBSP":
                Units = TBSP;
                break;
            case "FL_OUNCE":
                Units = FL_OUNCE;
                break;
            case "CUP":
                Units = CUP;
                break;
            case "PINT":
                Units = PINT;
                break;
            case "QUART":
                Units = QUART;
                break;
            case "GALLON":
                Units = GALLON;
                break;
            case "OZ":
                Units = OZ;
                break;
            case "POUND":
                Units = POUND;
                break;
        }
    }

    }
}
