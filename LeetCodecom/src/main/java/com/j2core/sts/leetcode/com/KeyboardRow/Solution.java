package com.j2core.sts.leetcode.com.KeyboardRow;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String[] findWords(String[] words) {

        List<String> wordList = new LinkedList<>();
        for (String word : words){
            if (containsInRow(word)){
                wordList.add(word);
            }
        }
        String[] newStringArray = new String[wordList.size()];
        for (int i = 0; i < wordList.size(); i++){
            newStringArray[i] = wordList.get(i);
        }
        return newStringArray;
    }


    private boolean containsInRow(String word){

        String firstRow = "QqWwEeRrTtYyUuIiOoPp";
        String secondRow = "AaSsDdFfGgHhJjKkLl";
        String thirdRow = "ZzXxCcVvBbNnMm";
        boolean result = true;
        for (int i = 0; i <  word.length(); i++){

            if (!firstRow.contains(String.valueOf(word.charAt(i)))){
                result = false;
                break;
            }
        }
        if (!result){
            result = true;
            for (int j = 0; j <  word.length(); j++){
                if (!secondRow.contains(String.valueOf(word.charAt(j)))){
                    result = false;
                    break;
                }
            }
        }
        if (!result){
            result = true;
            for (int k = 0; k <  word.length(); k++){
                if (!thirdRow.contains(String.valueOf(word.charAt(k)))){
                    return false;
                }
            }
        }
        return result;
    }
}
