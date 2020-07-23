package com.j2core.sts.leetcode.com.deletionDistance;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int deletionDistanceRecursion(String string1, String string2){

        return deletionDistance(string1, string2, 0, 0);

    }

    public int deletionDistance(String string1, String string2, int index1, int index2){

        if (index1 == string1.length() && index2 == string2.length()) return 0;

        if (index1 == string1.length()){
            return string2.length()-index2;
        }
        if (index2 == string2.length()) {
            return string1.length()-index1;
        }

        if (string1.charAt(index1) == string2.charAt(index2)){
            return deletionDistance(string1, string2, index1+1, index2+1);
        }else {
            return 1 + Math.min(deletionDistance(string1, string2, index1+1, index2), deletionDistance(string1, string2, index1, index2+1));
        }
    }

    public int deletionDistance(String string1, String string2){

        int maxLength = string1.length() + string2.length();

        removeUniqSymbols(string1, string2);

        int maxGeneralLength = 0;

        for (int i = 0; i < string1.length(); i++){
            int counter = 0;
            int index = 0;
            for (int j = i; j < string1.length(); j++){
                int tmpIndex = string2.indexOf(string1.charAt(j), index);
                if (tmpIndex > -1){
                    index = tmpIndex+1;
                    counter++;
                }
            }

            if (maxGeneralLength < counter) maxGeneralLength = counter;
        }

        return maxLength - (maxGeneralLength*2);
    }

    public void removeUniqSymbols(String first, String second){

        StringBuilder builderFirst = new StringBuilder();
        StringBuilder builderSecond = new StringBuilder();

        for (char symbol : first.toCharArray()){
            if (second.indexOf(symbol) > -1){
                builderFirst.append(symbol);
            }
        }

        for (char symbol : second.toCharArray()){
            if (first.indexOf(symbol) > -1){
                builderSecond.append(symbol);
            }
        }

        if (builderSecond.length() < builderFirst.length()){
            first = builderSecond.toString();
            second = builderFirst.toString();
        }else {
            first = builderFirst.toString();
            second = builderSecond.toString();
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(deletionDistance("abcd", "abc"), 1);
        Assert.assertEquals(deletionDistance("bbbcdab", "badcbbb"), 6);
        Assert.assertEquals(6, deletionDistance("thought", "sloughs"));
        Assert.assertEquals(9, deletionDistance("scapegoat", "basket"));
        Assert.assertEquals(7, deletionDistance("bgoatx", "akagoasta"));
    }
}
