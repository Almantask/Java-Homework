package cooking_converter;

public class Main {

    public static void main(String[] args) {

        RecipePrompt recipePrompt = new RecipePrompt();
        recipePrompt.run();
        System.out.println(CookingMeasurementConverter.convert(recipePrompt.getMeasurementFrom(), recipePrompt.getUnitTo()));
    }
}