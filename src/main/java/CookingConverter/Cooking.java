package CookingConverter;

import java.util.Arrays;
import java.util.List;

public class Cooking {
    static class Amounts {
        public static final float GRAMS = 1F;
        public static final float OZ = 28F;
        public static final float POUND = 454F;

        public static final float TSP = 5F;
        public static final float ML = 1F;
        public static final float TBSP = 15F;
        public static final float FL_OUNCE = 30F;
        public static final float CUP = 237F;
        public static final float PINT = 473F;
        public static final float QUART = 0.95F;
        public static final float GALLON = 3.80F;

    }

    static class Units {
        public static final String ML = "ML";
        public static final String GRAMS = "GRAMS";
        public static final String OZ = "OZ";
        public static final String POUND = "POUND";
        public static final String GALLON = "GALLON";
        public static final String QUART = "QUART";
        public static final String PINT = "PINT";
        public static final String CUP = "CUP";
        public static final String FL_OUNCE = "FL_OUNCE";
        public static final String TBSP = "TBSP";
        public static final String TSP = "TSP";

        public static boolean isValid(String unit) {
            return getValues().contains(unit);

        }

        public static List<String> getWeightValues() {
            return Arrays.asList(
                    GRAMS, OZ, POUND);
        }

        public static List<String> getVolumeValues() {
            return Arrays.asList(
                    ML, GALLON, QUART, PINT, CUP, FL_OUNCE, TBSP, TSP);
        }

        public static List<String> getValues() {
            return Arrays.asList(
                    ML, GRAMS, OZ, POUND, GALLON, QUART, PINT, CUP, FL_OUNCE, TBSP, TSP);
        }
    }
}