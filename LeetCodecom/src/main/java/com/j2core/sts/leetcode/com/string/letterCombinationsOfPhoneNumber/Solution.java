package com.j2core.sts.leetcode.com.string.letterCombinationsOfPhoneNumber;

import java.util.*;

public class Solution {

    public List<String> letterCombinationsOld(String digits) {

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

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() < 1) return new LinkedList<>();

        LinkedList<String> letterList = new LinkedList<>(Objects.requireNonNull(getCharacterList(digits.charAt(0))));

        for (int i = 1; i < digits.length(); i++){
            letterList = addNewLetter(letterList, getCharacterList(digits.charAt(i)));
        }

        return letterList;
    }

    private LinkedList<String> getCharacterList(Character num){

        switch (num){
            case '2':
                return new LinkedList<>(Arrays.asList("a", "b", "c"));
            case '3':
                return new LinkedList<>(Arrays.asList("d", "e", "f"));
            case '4':
                return new LinkedList<>(Arrays.asList("g", "h", "i"));
            case '5':
                return new LinkedList<>(Arrays.asList("j", "k", "l"));
            case '6':
                return new LinkedList<>(Arrays.asList("m", "n", "o"));
            case '7':
                return new LinkedList<>(Arrays.asList("p", "q", "r", "s"));
            case '8':
                return new LinkedList<>(Arrays.asList("t", "u", "v"));
            case '9':
                return new LinkedList<>(Arrays.asList("w", "x", "y", "z"));
        }

        return null;
    }

    private LinkedList<String> addNewLetter(List<String> base, List<String> adding){

        LinkedList<String> result = new LinkedList<>();

        for (String string : base){
            for (String add : adding){
                result.add(string.concat(add));
            }
        }

        return result;
    }

}
