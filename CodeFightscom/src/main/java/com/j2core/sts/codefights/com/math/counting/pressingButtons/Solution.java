package com.j2core.sts.codefights.com.math.counting.pressingButtons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    String[] pressingButtons(String buttons) {

        String[] two  = new String[]{"a", "b", "c"};
        String[] three = new String[]{"d", "e", "f"};
        String[] four = new String[]{"g", "h", "i"};
        String[] five = new String[]{"j", "k", "l"};
        String[] six = new String[]{"m", "n", "o"};
        String[] seven = new String[]{"p", "q", "r", "s"};
        String[] eight = new String[]{"t", "u", "v"};
        String[] nine = new String[]{"w", "x", "y", "z"};
        List<String> result = new ArrayList<>();

        for (int i = 0; i < buttons.length(); i++){

            switch (buttons.charAt(i)){

                case '2':
                    result = addValue(two, result);
                    break;
                case '3':
                    result = addValue(three, result);
                    break;
                case '4':
                    result = addValue(four, result);
                    break;
                case '5':
                    result = addValue(five, result);
                    break;
                case '6':
                    result = addValue(six, result);
                    break;
                case '7':
                    result = addValue(seven, result);
                    break;
                case '8':
                    result = addValue(eight, result);
                    break;
                case '9':
                    result = addValue(nine, result);
                    break;
                default:
                    break;
            }

        }

        return result.toArray(new String[0]);
    }


    private List<String> addValue(String[] numValue, List<String> varList){

        if (varList.size() == 0){

            varList.addAll(Arrays.asList(numValue));

            return varList;

        }else {

            List<String> result = new ArrayList<>();

            for(String var : varList){

                for (String value : numValue){

                    result.add(var+value);

                }
            }

            return result;

        }
    }
}
