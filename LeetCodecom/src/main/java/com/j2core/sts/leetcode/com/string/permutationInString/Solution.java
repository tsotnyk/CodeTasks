package com.j2core.sts.leetcode.com.string.permutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> map = createPermutationMap(s1);

        for (int i = 0; i <= s2.length()-s1.length(); i++){

            if (map.containsKey(s2.charAt(i))){
                if (isPermutation(s2.substring(i, i+ s1.length()), map)) return true;
            }
        }

        return false;
    }

    private boolean isPermutation(String string, Map<Character, Integer> map){

        int[] array = new int[126];
        for (int i = 0; i < string.length(); i++){
            array[string.charAt(i)] += 1;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (array[entry.getKey()] != entry.getValue()) return false;
        }
        return true;
    }

    private Map<Character, Integer> createPermutationMap(String string){

        HashMap<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < string.length(); i++){

            result.put(string.charAt(i), result.getOrDefault(string.charAt(i), 0)+1);
        }

        return result;
    }
}
