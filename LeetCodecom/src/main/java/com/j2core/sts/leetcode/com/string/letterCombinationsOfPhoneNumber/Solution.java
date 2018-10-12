package com.j2core.sts.leetcode.com.string.letterCombinationsOfPhoneNumber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> letterCombinations(String digits) {

        List<StringBuilder> tmpResult = new LinkedList<>();
        Map<Integer, String> map = createMap();

        for (int i = 0; i < digits.length(); i++){

            int num = Integer.parseInt(digits.substring(i, i+1));
            String tmpStr = map.get(num);

            if (tmpResult.isEmpty()){
                for (int j = 0; j  < tmpStr.length(); j++){
                    tmpResult.add(new StringBuilder().append(tmpStr.charAt(j)));
                }
            }else {

                List<StringBuilder> newBuilders = new LinkedList<>();

                for (StringBuilder builder : tmpResult){

                    for (int j = 0; j < tmpStr.length(); j++){

                        newBuilders.add(new StringBuilder().append(builder).append(tmpStr.charAt(j)));

                    }

                }

                tmpResult = newBuilders;
            }
        }

        return createStringList(tmpResult);
    }

    private Map<Integer, String> createMap(){

        String[] array = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        Map<Integer, String> map = new HashMap<>();

        for(int i = 2; i < 10; i++ ){

            map.put(i, array[i]);
        }
        return map;
    }

    private List<String> createStringList(List<StringBuilder> builders){

        List<String> result = new LinkedList<>();

        for (StringBuilder builder : builders){

            result.add(builder.toString());
        }
        return result;
    }
}
