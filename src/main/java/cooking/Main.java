package cooking;


    public class Main {
        public static void main(String[] args) {
            ReceipePrompt receipePrompt = new ReceipePrompt();

            receipePrompt.run();
            System.out.println(receipePrompt.getUnit());
            System.out.println(receipePrompt.getAmount());
            CookingMeasurement cookingMeasurement = new CookingMeasurement(receipePrompt.getAmount(), receipePrompt.getUnit());
            CookingMeasurement result = CookingMeasurementConverter.convert(cookingMeasurement, "Blablabla");
            System.out.println(result.getAmount());
            System.out.println(result.getUnit());
        }
    }
