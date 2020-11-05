package CookingConvertor;


public class Cooking {

    public static void main(String[] args) {

        ReceipePrompt converter = new ReceipePrompt();
        converter.recipeFromStringConverter();
//        ReceipePrompt prompt = new ReceipePrompt();
//        prompt.run();
    }

    public static class Amounts {
        private static final float TSP = 5f;
        private static final float ML = 1f;
        private static final float OZ = 28f;
        private static final float POUND= 454f;
        private static final float GALLON= 3.8f;
        private static final float QUART= 0.95f;
        private static final float PINT= 473f;
        private static final float CUP= 237f;
        private static final float FL_OUNCE= 30f;
        private static final float TBSP= 15f;

        public static float value (String unit) {
            switch (unit) {
                case Units.TSP:
                    return TSP;
                case Units.ML:
                    return ML;
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
                default:
                return 0;
            }
        }

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

        public static float switching (CookingMeasurement originalMeasurement,String unit) {
            float newAmount = 0;
            switch (unit.toUpperCase()) {
                case "TSP":
                    newAmount = (value(originalMeasurement.getUnit()) / getTSP()) * originalMeasurement.getAmount();
                    break;
                case "OZ":
                    newAmount = (value(originalMeasurement.getUnit()) / getOZ()) * originalMeasurement.getAmount();
                    break;
                case "POUND":
                    newAmount = (value(originalMeasurement.getUnit()) / getPOUND()) * originalMeasurement.getAmount();
                    break;
                case "QUART":
                    newAmount = (value(originalMeasurement.getUnit()) / getQUART()) * originalMeasurement.getAmount();
                    break;
                case "GALLON":
                    newAmount = (value(originalMeasurement.getUnit()) / getGALLON()) * originalMeasurement.getAmount();
                    break;
                case "PINT":
                    newAmount = (value(originalMeasurement.getUnit()) / getPINT()) * originalMeasurement.getAmount();
                    break;
                case "CUP":
                    newAmount = (value(originalMeasurement.getUnit()) / getCUP()) * originalMeasurement.getAmount();
                    break;
                case "FL_OUNCE":
                    newAmount = (value(originalMeasurement.getUnit()) / getFlOunce()) * originalMeasurement.getAmount();
                    break;
                case "TBSP":
                    newAmount = (value(originalMeasurement.getUnit()) / getTBSP()) * originalMeasurement.getAmount();
                    break;
                case "ML":
                    newAmount = (value(originalMeasurement.getUnit()) / getML()) * originalMeasurement.getAmount();
                    break;
                default:
                    System.out.println("Enter again");
            }
            return newAmount;
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
        public static final String ML= "ML";

        public static String[] values = {OZ,POUND,PINT,GALLON,QUART,CUP,FL_OUNCE,TSP,TBSP,ML};

        public static boolean isValid (String input) {
            for (String value : values) {
                if (input.toUpperCase().equals(value)) {
                    return true;
                }
            }
            return false;
        }



    }



}

