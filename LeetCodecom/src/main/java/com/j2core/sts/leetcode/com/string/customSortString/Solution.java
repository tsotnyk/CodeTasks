package com.j2core.sts.leetcode.com.string.customSortString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String customSortString(String S, String T) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < T.length(); i++){

            char tmp = T.charAt(i);

            if (map.containsKey(tmp)){

                int value = map.get(tmp);
                map.put(tmp, value+1);
            }else {

                map.put(tmp, 1);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int j = 0; j < S.length(); j++){

            char tmp = S.charAt(j);

            if (map.containsKey(tmp)) {
                int value = map.remove(tmp);

                for (int k = 0; k < value; k++) {
                    result.append(tmp);
                }
            }
        }

        if (!map.isEmpty()){

            Set<Map.Entry<Character, Integer>> set = map.entrySet();

            for (Map.Entry<Character, Integer> entry : set){

                char tmp = entry.getKey();
                int value = entry.getValue();
                for (int l = 0; l < value; l++){
                    result.append(tmp);
                }
            }
        }

        return result.toString();
    }


    @Test
    public void test(){

        String result = customSortString("cbafg", "abcd");

        Assert.assertEquals("cbad", result);

    }
}
