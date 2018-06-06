package com.j2core.sts.codefights.com.math.counting.stringPermutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {

    String[][] groupingDishes(String[][] dishes) {

        List<String[]> tmpResult = new LinkedList<>();

        for (int i = 0; i < dishes.length; i++) {

            for (int j = 1; j < dishes[i].length; j++) {

                if (!existIngredient(tmpResult, dishes[i][j])) {

                    String[] dishArray = findDishes(dishes[i][j], dishes[i][0], i, dishes);

                    if (dishArray.length > 2) {

                        tmpResult.add(dishArray);

                    }
                }
            }
        }

        String[][] result = new String[tmpResult.size()][];

        for (int k = 0; k < result.length; k++){

            result[k] = tmpResult.get(k);

        }
        return null;

//        return sortIngredients(result);
    }






//    private String[][] sortIngredients(String[][] array){
//
//        String[] tmp;
//
//        for (int i = 1; i < array.length; i++){
//
//            String str = array[i][0];
//
//            for (int j = 0; j < i; j++){
//
//                if (array[j][0].charAt(0) > str.charAt(0)){
//
//                    tmp = array[j];
//                    array[j] = array[i];
//                    array[i] = tmp;
//
//                }else if (array[j][0].charAt(0) == str.charAt(0)) {
//
//                    if (array[j][0].length() > str.length()) {
//                        tmp = array[j];
//                        array[j] = array[i];
//                        array[i] = tmp;
//                    } else if (array[j][0].length() == str.length()) {
//
//                        int index = 1;
//
//                        while (array[j][0].charAt(index) == str.charAt(index) && index < str.length()) {
//                            index++;
//                        }
//
//                        if (array[j][0].charAt(index) > str.charAt(index)) {
//
//                            tmp = array[j];
//                            array[j] = array[i];
//                            array[i] = tmp;
//
//                        }
//                    }
//                }
//            }
//        }
//
//        return array;
//    }


    private boolean existIngredient(List<String[]> list, String ingredient){

        for (String[] row : list){

            if (equalsNameIngredient(ingredient, row[0])){

                return true;

            }
        }

        return false;

    }


    private String[] findDishes(String ingredient, String dish, int dishIndex, String[][] dishes) {

        List<String> dishList = new LinkedList<>();
        dishList.add(dish);

        for (int i = 0; i < dishes.length; i++) {

            if (i != dishIndex) {

                for (int j = 1; j < dishes[i].length; j++) {

                    if (equalsNameIngredient(ingredient, dishes[i][j])) {

                        dishList.add(dishes[i][0]);
                        break;

                    }
                }
            }
        }

        return sort(dishList, ingredient);

    }


    private String[] sort(List<String> dishList, String ingredient) {

        String[] result = new String[dishList.size() + 1];

        result[0] = ingredient;

        for (int i = 0; i < dishList.size(); i++) {

            result[i + 1] = dishList.get(i);

        }

        Arrays.sort(result, 1, result.length);

        return result;

    }


    private boolean equalsNameIngredient(String ingredient, String string) {

        int ingLength = ingredient.length();
        int strLength = string.length();
        if (ingLength != strLength) return false;

        for (int i = 0; i < ingLength; i++) {

            if (ingredient.charAt(i) != string.charAt(i)) {

                return false;

            }
        }
        return true;
    }


    public String convert(String tmp){


//        tmp.replaceAll("", "{");

        tmp.replaceAll("]", "}");

        return tmp;

    }


}
