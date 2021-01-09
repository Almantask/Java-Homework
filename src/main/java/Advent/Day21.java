package Advent;

import java.util.*;

public class Day21 {

    public static void solve(List<String> input) {

//        System.out.println(input);
        System.out.println(getIngredientsWithAllergens(input));
//        findIngredient(getIngredientsWithAllergens(input));
//        System.out.println(getIngredientsWithoutAllergens(input).size());
    }

    private static int solvePart1(List<String> input) {


        return 0;
    }

    private static List<String> getIngredientsWithoutAllergens(List<String> input) {
        List<String> ingredientsWithAllergens = getIngredientsWithAllergens(input);
        List<String> allIngredients = new ArrayList<>();
        for (String s : input)
            allIngredients.addAll(getIngredients(s));
        allIngredients.removeAll(ingredientsWithAllergens);


//        for (String ingredient : allIngredients)
//            for (String withAllergen : ingredientsWithAllergens)
//                if (ingredient.equals(withAllergen))
//                    ingredientsWithoutAllergens.remove(ingredient);
//        System.out.println(ingredientsWithoutAllergens);
        return allIngredients;
    }

    private static List<String> getIngredientsWithAllergens(List<String> input) {
        List<String> ingredientsWithAllergens = new ArrayList<>();
        HashMap<String, List<String>> allergens_ingredients = new HashMap<>();
//        System.out.println(!isAllergensAssignedToOneIngredients(allergens_ingredients));
        while (allergens_ingredients.isEmpty() || !isAllergensAssignedToOneIngredients(allergens_ingredients)) {
            for (String foods : input)
                for (String allergen : getAllergens(foods)) {
                    List<String> ingredients = new ArrayList<>();
                    if (allergens_ingredients.get(allergen) != null)
                        ingredients.addAll(allergens_ingredients.get(allergen));
//                if (ingredients.size() != 1) {
                    ingredients.addAll(getIngredients(foods));
                    if (!findIngredient(ingredients).isEmpty()) {
                        ingredientsWithAllergens.add(findIngredient(ingredients));
                        ingredients = new ArrayList<>(Collections.singletonList(findIngredient(ingredients)));
                    }
                    allergens_ingredients.put(allergen, ingredients);
                    System.out.println(allergens_ingredients.size());
                    allergens_ingredients = new HashMap<>(rearrangeIngredients(allergens_ingredients, ingredientsWithAllergens));
                }
        }
//        System.out.println(allergens_ingredients);
//        System.out.println(ingredientsWithAllergens);
        System.out.println(allergens_ingredients);
//        for (List<String> s : allergens_ingredients.values())
//            System.out.println(s);
        return changeMapToList(allergens_ingredients);
    }

    private static boolean isAllergensAssignedToOneIngredients (HashMap<String, List<String>> allergens) {
        for (List<String> list : allergens.values())
            if (list.size() > 1)
                return false;
        return true;
    }

    private static List<String> changeMapToList(HashMap<String, List<String>> map) {
        List<String> newList = new ArrayList<>();
        for (List<String> s : map.values())
            newList.add(s.get(0));
        return newList;
    }

    private static HashMap<String, List<String>> rearrangeIngredients(HashMap<String, List<String>> allergens, List<String> ingredients) {
        HashMap<String, List<String>> rearranged = new HashMap<>();
        for (List<String> value : allergens.values())
            if (value.size() != 1)
                for (String ingredient : ingredients)
                    value.remove(ingredient);

        return allergens;
    }

    private static String findIngredient(List<String> ingredients) {
//        System.out.println("11 " + ingredients);
        String ingredient = "";
//        if (ingredients.size() == 1)
//            return ingredients.get(0);
        List<String> ingredientsToCheck = new ArrayList<>(ingredients);
        for (String s : ingredients) {
            int countDoubles = 0;
            for (String ss : ingredients)
                if (s.equals(ss))
                    countDoubles += 1;
            if (countDoubles == 1)
                ingredientsToCheck.remove(s);
        }
        if (!ingredientsToCheck.isEmpty() && checkIfAllValueIsEqual(ingredientsToCheck))
            ingredient = ingredientsToCheck.get(0);
        return ingredient;
    }

    private static boolean checkIfAllValueIsEqual(List<String> strings) {
        for (String s : strings)
            if (!s.equals(strings.get(0)))
                return false;
        return true;

    }

    private static List<String> getIngredients(String ingredientsList) {
        String ingredientsToString = ingredientsList.substring(0, ingredientsList.indexOf(" ("));
        return new ArrayList<>(Arrays.asList(ingredientsToString.split(" ")));
    }

    private static List<String> getAllergens(String ingredientsList) {
        String allergensToString = ingredientsList.substring(ingredientsList.indexOf("(") + 10, ingredientsList.length() - 1);
        return new ArrayList<>(Arrays.asList(allergensToString.split(", ")));
    }

//    private static boolean isDuplicate (List<String> strings){
//        for (String s : strings)
//            if(s.split(" ").length > 1)
//                return false;
//        return true;
//    }
//
//    private static String removeIterativeIngredients(String ingredient, String ingredients) {
//        List<String> newString = new ArrayList<>();
//        for (String s : ingredients.split(" "))
//            if (!s.equals(ingredient))
//                newString.add(s);
//        return String.join(" ", newString);
//    }
//
//    private static List<String> getIngredientsWithSomeAllergen(String allergen, List<String> input) {
//        List<String> ingredients = new ArrayList<>();
//        for (String s : input)
//            if (s.contains(allergen))
//                ingredients.add(getIngredients(s));
//        return ingredients;
//    }
//
//    private static String removeIngredients(String ingredients1, String ingredients2) {
//        List<String> ingredients = new ArrayList<>();
//        for (String s1 : ingredients1.split(" "))
//            for (String s2 : ingredients2.split(" "))
//                if (s1.equals(s2))
//                    ingredients.add(s1);
//        return String.join(" ", ingredients);
//    }
//
//    private static String getIngredients(String ingredientsList) {
//        return ingredientsList.substring(0, ingredientsList.indexOf(" ("));
////        return new ArrayList<>(Arrays.asList(ingredientsToString.split(" ")));
//    }
//
//    private static List<String> getAllAllergens(List<String> input) {
//        List<String> allAllergens = new ArrayList<>();
//        for (String s : input)
//            allAllergens.addAll(getAllergens(s));
//        Set<String> s =  new HashSet<>(allAllergens);
////        System.out.println("T " + s + " : " + allAllergens);
//        return allAllergens;
//    }
//
//    private static List<String> getAllergens(String ingredientsList) {
//        String allergensToString = ingredientsList.substring(ingredientsList.indexOf("(") + 10, ingredientsList.length() - 1);
//        return new ArrayList<>(Arrays.asList(allergensToString.split(", ")));
//    }

}

