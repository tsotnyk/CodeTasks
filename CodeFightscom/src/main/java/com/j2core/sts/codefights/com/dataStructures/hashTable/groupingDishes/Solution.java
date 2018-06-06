package com.j2core.sts.codefights.com.dataStructures.hashTable.groupingDishes;

import java.util.*;

public class Solution {

    String[][] groupingDishes(String[][] dishes) {

        List<List<String>> resultList = createIngredientsList(dishes);

        String[][] result = new String[resultList.size()][];

        for (int i = 0; i < resultList.size(); i++){

            List<String> tmpList = resultList.get(i);

            String[] tmpArray = new String[tmpList.size()];

            for (int j = 0; j < tmpList.size(); j++){

                tmpArray[j] = tmpList.get(j);

            }

            Arrays.sort(tmpArray, 1, tmpArray.length);
            result[i] = tmpArray;

        }

        return result;
    }


    private String[] sortIngredients(List<String> ingredientsList){

        String[] result = new String[ingredientsList.size()];

        for (int i = 0; i < ingredientsList.size(); i++){

            result[i]  = ingredientsList.get(i);

        }

        Arrays.sort(result);

        return result;
    }


    private List<List<String>> createIngredientsList(String[][] dishes){

        Map<String, List<String>> ingredientsMap = new HashMap<>();
        List<String> ingredients = new LinkedList<>();
        List<List<String>> result = new LinkedList<>();

        for (String[] dish1 : dishes) {

            for (int j = 1; j < dish1.length; j++) {

                if (!ingredientsMap.containsKey(dish1[j])) {

                    List<String> tmp = new LinkedList<>();
                    tmp.add(dish1[j]);
                    ingredientsMap.put(dish1[j], tmp);
                    ingredients.add(dish1[j]);
                }
            }
        }

        String[] sortIng = sortIngredients(ingredients);

        for (String tmp : sortIng){

            for (String[] dish : dishes) {

                for (int j = 1; j < dish.length; j++) {

                    if (equalsIngredient(tmp, dish[j])) {

                        List<String> tmpList = ingredientsMap.get(tmp);
                        tmpList.add(dish[0]);
                    }
                }
            }
        }

        for (String tmp : sortIng){

            List<String> tmpList = ingredientsMap.get(tmp);
            if (tmpList.size() > 2){

                result.add(tmpList);
            }
        }

        return result;
    }


    private boolean equalsIngredient(String base, String value){

        if (base.length() != value.length()) return false;

        for (int i = 0; i < base.length(); i++){

            if (base.charAt(i) != value.charAt(i)){

                return false;

            }
        }
        return true;
    }
}
