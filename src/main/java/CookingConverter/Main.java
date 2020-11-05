package CookingConverter;

public class Main {

    public static void main(String[] args) {

        ReceipePrompt receipePrompt = new ReceipePrompt();
        receipePrompt.run();
        System.out.println(CookingMeasurementConverter.convert(receipePrompt.getMeasurementFrom(), receipePrompt.getUnitTo()));
    }
}