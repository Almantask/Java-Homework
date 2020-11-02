package CookingConvertor;

import java.util.Arrays;
import java.util.Objects;

public class Cooking {

    public static void main(String[] args) {

        ReceipePrompt prompt = new ReceipePrompt();
        prompt.run();


    }
    public static class Amounts {
        public static final float TSP = 5f;
        public static final float ML = 1f;
        public static final float OZ = 28f;
        public static final float POUND= 454f;
        public static final float GALLON= 3.8f;
        public static final float QUART= 0.95f;
        public static final float PINT= 473f;
        public static final float CUP= 237f;
        public static final float FL_OUNCE= 30f;
        public static final float TBSP= 15f;

        public static float getTSP() {
            return TSP;
        }

        public static float getML() {
            return ML;
        }

        public static float getOZ() {
            return OZ;
        }

        public static float getPOUND() {
            return POUND;
        }

        public static float getGALLON() {
            return GALLON;
        }

        public static float getQUART() {
            return QUART;
        }

        public static float getPINT() {
            return PINT;
        }

        public static float getCUP() {
            return CUP;
        }

        public static float getFlOunce() {
            return FL_OUNCE;
        }

        public static float getTBSP() {
            return TBSP;
        }
    }

    public static class Units {



        public static final String OZ = "OZ";
        public static final String POUND= "POUND";
        public static final String GALLON= "GALLON";
        public static final String QUART= "QUART";
        public static final String PINT= "PINT";
        public static final String CUP= "CUP";
        public static final String FL_OUNCE= "FL_OUNCE";
        public static final String TBSP= "TBSP";
        public static final String TSP= "TSP";


        private static String [] getValues() {
            return new String [] {"OZ","POUND","GALLON","QUART","POUND","CUP","FL_OUNCE","TBSP","TSP","PINT"};
        }

    }



}

