package com.j2core.sts.codefights.com.math.counting.stringPermutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    String[] stringPermutations(String s) {

        if (s.length() < 2) return new String[]{s};

        int sLength = s.length();

        List<String> permutations = createPermutationString(String.valueOf(s.charAt(sLength-1)), String.valueOf(s.charAt(s.length()-2)));

        for (int i = sLength-1-2; i > -1; i--){

            List<String> tmpResult = new LinkedList<>();

            for (String tmpStr : permutations){

                tmpResult.addAll(createPermutationString(tmpStr, String.valueOf(s.charAt(i))));

            }
            permutations = tmpResult;
        }

        String[] result = new String[permutations.size()];

        for (int i = 0; i < permutations.size(); i++){

            result[i] = permutations.get(i);

        }

        Arrays.sort(result);

        result = dropRepeatPermutation(result);

        return result;
    }


    private String[] dropRepeatPermutation(String[] permutation){

        boolean lastString = true;
        String[] result = new String[permutation.length];

        int index = 0;
        for (int i = 0; i < permutation.length-1; i++){

            if (equalsString(permutation[i], permutation[i+1])){
                i++;
                if (i == permutation.length-1){
                    lastString = false;
                }
            }

            result[index] = permutation[i];
            index++;
        }

        if (lastString){

            result[index] = permutation[permutation.length-1];
            index++;
        }

        return Arrays.copyOf(result, index);

    }


    private boolean equalsString(String first, String second){

        for (int i = 0; i < first.length(); i++){

            if (first.charAt(i) != second.charAt(i)){

                return false;

            }
        }

        return true;
    }


    private List<String> createPermutationString(String str, String variable){

        List<String> result = new LinkedList<>();

        result.add(variable + str);

        for (int i = 0; i < str.length()-1; i++){

            result.add(str.substring(0, i+1) + variable + str.substring(i+1));

        }

        result.add(str + variable);

        return result;
    }
}
