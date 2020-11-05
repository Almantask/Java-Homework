package Cooking;

public class Cooking {

    public static class Units {
        public static final String ML = "ML";
        public static final String TSP = "TSP";
        public static final String TBSP = "TBSP";
        public static final String FL_OUNCE = "FL_OUNCE";
        public static final String CUP = "CUP";
        public static final String PINT = "PINT";
        public static final String QUART = "QUART";
        public static final String GALLON = "GALLON";

        public static String[] getValues(){
            return new String[] {ML, TSP, TBSP, FL_OUNCE, CUP, PINT, QUART, GALLON};
        }

        public static Boolean unitExists (String unit){
            for (int i = 0; i < Cooking.Units.getValues().length; i++){
                if (getValues()[i].equals(unit)){
                    return true;
                }
            }
            return false;
        }
    }

    public static class Amounts {
        public static final float ML = 1;
        public static final float TSP = 5;
        public static final float TBSP = 15;
        public static final float FL_OUNCE = 30;
        public static final float CUP = 237;
        public static final float PINT = 473;
        public static final float QUART = 948;
        public static final float GALLON = 3792;

        public static float[] getValues(){
            return new float[] {ML, TSP, TBSP, FL_OUNCE, CUP, PINT, QUART, GALLON};
        }
    }
}
