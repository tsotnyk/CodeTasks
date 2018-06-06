package com.j2core.sts.codefights.com.dataStructures.hashTable.areFollowingPatterns;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    boolean areFollowingPatterns(String[] strings, String[] patterns) {

        Map<String, String> patternString = new HashMap<>();

        for (int i = 0; i < strings.length; i++){

            if (!patternString.containsKey(strings[i])){

                if (!patternString.containsValue(patterns[i])){
                    patternString.put(strings[i], patterns[i]);
                }else {
                    return false;
                }

            }else {

                if (!patternString.containsValue(patterns[i])){
                    return false;
                }else {

                    String baseStr = patternString.get(strings[i]);
                    if (!equalsString(baseStr, patterns[i])){
                        return false;
                    }
                }
            }
        }

        return true;
    }


    private boolean equalsString(String base, String value){

        if (base.length() != value.length()) return false;

        for (int i = 0; i < base.length(); i++){

            if (base.charAt(i) != value.charAt(i)){

                return false;

            }
        }
        return true;
    }

}
