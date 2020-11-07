package cooking;

public class Cooking {
    public static class Units {
        public static final String TSP = "TSP";
        public static final String TBSP = "TBSP";
        public static final String FL_OUNCE = "FL_OUNCE";
        public static final String CUP = "CUP";
        public static final String PINT = "PINT";
        public static final String QUART = "QUART";
        public static final String GALLON = "GALLON";
        public static final String OZ = "OZ";
        public static final String POUND = "POUND";


        public static String[] getValues() {

            return new String[]{TSP, TBSP, FL_OUNCE, CUP, PINT, QUART, GALLON, OZ, POUND};
        }

        public static class Amounts {
            public static final float ML = 1;
            public static final float TSP = 5;
            public static final float TBSP = 15;
            public static final float FL_OUNCE = 30;
            public static final float CUP = 237;
            public static final float PINT = 437;
            public static final float QUART = 950;
            public static final float GALLON = 3800;
            public static final float OZ = 28;
            public static final float POUND = 454;

        }
    }
}


