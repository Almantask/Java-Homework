public class Cooking {

    static class Units {

        public static final String OZ = "OZ";
        public static final String POUND = "POUND";
        public static final String GALLON = "GALLON";
        public static final String QUART = "QUART";
        public static final String PINT = "PINT";
        public static final String CUP = "CUP";
        public static final String FL_OUNCE = "FL_OUNCE";
        public static final String TBSP = "TBSP";
        public static final String TSP = "TSP";
        public static final String ML = "ML";

        public static String[] getValues() {
            String[] units = {"OZ", "POUND", "GALLON", "QUART", "PINT",
                    "CUP", "FL_OUNCE", "TBSP", "TSP", "ML"};
            return units;
        }

        public static boolean isValid(String units) {
            boolean result = false;
            for (int i = 0; i < getValues().length; i++) {
                if (getValues()[i].equals(units)) {
                    result = true;
                    break;
                } else {
                    result = false;
                }
            }
            return result;
        }
    }

    static class Amounts {

        public static final float OZ = 28;
        public static final float POUND = 454;
        public static final float GALLON = 3800;
        public static final float QUART = 948;
        public static final float PINT = 473;
        public static final float CUP = 237F;
        public static final float FL_OUNCE = 30F;
        public static final float TBSP = 15F;
        public static final float TSP = 5F;
        public static final float ML = 1;

        public static float convert(String unit) {
            switch (unit) {

                case Units.TSP:
                    return TSP;
                case Units.OZ:
                    return OZ;
                case Units.POUND:
                    return POUND;
                case Units.GALLON:
                    return GALLON;
                case Units.QUART:
                    return QUART;
                case Units.PINT:
                    return PINT;
                case Units.CUP:
                    return CUP;
                case Units.FL_OUNCE:
                    return FL_OUNCE;
                case Units.TBSP:
                    return TBSP;
                case Units.ML:
                    return ML;
                default:
                    return 0F;
            }

        }


    }
}