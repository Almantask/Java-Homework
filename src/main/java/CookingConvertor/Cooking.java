package CookingConvertor;


public class Cooking {

    public static void main(String[] args) {
        ReceipePrompt prompt = new ReceipePrompt();
//        prompt.run();
        prompt.recipeFromStringConverter();
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
                if (input.toUpperCase().equals(value.toUpperCase())) {
                    return false;
                }
            }
            return true;
        }
    }
}


