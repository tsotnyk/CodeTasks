package com.j2core.sts.leetcode.com.string.longestCommonPrefix;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length < 1){
            return "";
        }else if (strs.length < 2){
            return strs[0];
        }else {

            String minWord = strs[0];
            String maxWord = strs[1];

            for (String string : strs) {

                if (string.length() < minWord.length()) {
                    minWord = string;
                } else if (string.length() > maxWord.length()) {
                    maxWord = string;
                }
            }

            List<String> subStringList = createSubStringList(minWord, maxWord);

            boolean flag = false;
            String tmpResult = "";

            for (String string : subStringList) {

                tmpResult = string;
                flag = true;
                for (String word : strs) {

                    for (int i = 0; i < string.length(); i++){

                        if (string.charAt(i) != word.charAt(i)){
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
                if (flag) break;
            }

            return flag ? tmpResult : "";
        }
    }

    private List<String> createSubStringList(String minWord, String maxWord){

        List<String> subStringList = new LinkedList<>();

        int amountChar = -1;

        for (int i = 0; i < minWord.length(); i++){
            if (minWord.charAt(i) == maxWord.charAt(i)){
                amountChar++;
            }else {
                break;
            }
        }

        for (int j = amountChar; j > -1; j--){

            if (j == maxWord.length()-1){
                subStringList.add(maxWord);
            }else {
                subStringList.add(maxWord.substring(0, j+1));
            }
        }

        return subStringList;
    }


    @Test
    public void test(){

        String result = longestCommonPrefix(new String[]{"aca", "cba"});

        Assert.assertEquals("", result);

    }
}
