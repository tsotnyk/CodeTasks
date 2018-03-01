package com.j2core.sts.leetcode.com.keyboardRow;

import java.util.LinkedList;
import java.util.List;

/*
   The class return the words that can be typed using letters of alphabet on only one row's of American keyboard.
 */
public class Solution {

    /**
     * The method returned new array with words witch can be typed using letters of alphabet on only one row's of American keyboard.
     *
     * @param words     basic array with words
     * @return          returned array
     */
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

    /**
     * The method check can be typed using letters of alphabet on only one row's of American keyboard for write this word
     *
     * @param word  word witch need check
     * @return     can be typed using letters of alphabet on only one row's or not
     */
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
