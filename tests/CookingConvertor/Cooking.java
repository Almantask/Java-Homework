package CookingConvertor;


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

        public static float switching (CookingMeasurement originalMeasurement,String unit) {
            float newAmount = 0;
            switch (unit.toUpperCase()) {
                case "TSP":
                    switch (originalMeasurement.getUnit()) {
                        case "OZ":
                            newAmount = (getTSP() / getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getTSP() / getPOUND()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getTSP() / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getTSP() / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getTSP() / getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getTSP() / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getTSP() / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getTSP() / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getTSP()  / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "OZ":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getOZ() / getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getOZ() / getPOUND()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getOZ() / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getOZ() / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getOZ() / getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getOZ() / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getOZ() / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getOZ() / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getOZ() / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "POUND":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getPOUND()/ getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "OZ":
                            newAmount = (getPOUND() / getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getPOUND() / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getPOUND() / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getPOUND() / getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getPOUND() / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getPOUND() / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getPOUND() / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getPOUND() / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "QUART":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getQUART()/ getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "OZ":
                            newAmount = (getQUART() / getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getQUART() / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getQUART() / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getQUART() / getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getQUART() / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getQUART() / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getQUART() / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getQUART() / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "GALLON":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getGALLON() / getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "OZ":
                            newAmount = (getGALLON() / getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getGALLON() / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getGALLON() / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getGALLON() / getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getGALLON() / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getGALLON() / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getGALLON() / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getGALLON() / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "PINT":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getPINT() / getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "OZ":
                            newAmount = (getPINT() / getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getPINT() / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getPINT() / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getPINT()/ getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getPINT() / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getPINT() / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getPINT() / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getPINT() / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "CUP":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getCUP() / getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "OZ":
                            newAmount = (getCUP() / getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getCUP() / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getCUP() / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getCUP()/ getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getCUP() / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getCUP() / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getCUP() / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getCUP() / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "FL_OUNCE":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getFlOunce() / getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "OZ":
                            newAmount = (getFlOunce()  / getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getFlOunce()  / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getFlOunce()  / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getFlOunce() / getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getFlOunce()  / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getFlOunce()  / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getFlOunce()  / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getFlOunce()  / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "TBSP":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getTBSP() / getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "OZ":
                            newAmount = (getTBSP()/ getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getTBSP()  / getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getTBSP()  / getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getTBSP() / getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getTBSP()  / getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getTBSP()  / getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getTBSP()  / getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "ML":
                            newAmount = (getTBSP() / getML()) * originalMeasurement.getAmount();
                            break;
                    }
                    break;
                case "ML":
                    switch (originalMeasurement.getUnit()) {
                        case "TSP":
                            newAmount = (getML() * getTSP()) * originalMeasurement.getAmount();
                            break;
                        case "OZ":
                            newAmount = (getML() * getOZ()) * originalMeasurement.getAmount();
                            break;
                        case "POUND":
                            newAmount = (getML() * getQUART()) * originalMeasurement.getAmount();
                            break;
                        case "QUART":
                            newAmount = (getML() * getGALLON()) * originalMeasurement.getAmount();
                            break;
                        case "GALLON":
                            newAmount = (getML() * getPINT()) * originalMeasurement.getAmount();
                            break;
                        case "PINT":
                            newAmount = (getML() * getCUP()) * originalMeasurement.getAmount();
                            break;
                        case "CUP":
                            newAmount = (getML() * getFlOunce()) * originalMeasurement.getAmount();
                            break;
                        case "FL_OUNCE":
                            newAmount = (getML() * getTBSP()) * originalMeasurement.getAmount();
                            break;
                        case "TBSP":
                            newAmount = (getML() * getML()) * originalMeasurement.getAmount();
                            break;
                    }
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
                    return false;
                }
            }
            return true;
        }



    }



}

