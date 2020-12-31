package com.j2core.sts.codefights.com.specialTopics.strings.longestCommonSubsting;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    int longestCommonSubstringTLE(String s, String t) {

        if (s.length() == 1 || t.length() == 1) return 1;
        int maxLength = 0;
        String smaller;
        String bigger;

        if (s.length() <= t.length()){
            smaller = s;
            bigger = t;
        }else {
            smaller = t;
            bigger = s;
        }

        int index = 0;

        while (index < smaller.length() && smaller.length()-index > maxLength){

            maxLength = Math.max(maxLength, findLengthOfSameSubstring(smaller, smaller.charAt(index), index+1, bigger, maxLength));
            index++;
        }

        return maxLength;
    }

    private int findLengthOfSameSubstring(String smaller, char symbol, int indexS, String bigger, int length) {

        int maxLength = 0;
        int indexB = bigger.indexOf(symbol);
        while (indexB > -1 && bigger.length() - indexB > length){
            int tmpLength = 1;
            int index = indexB+1;
            while (index < bigger.length() && indexS < smaller.length() && smaller.charAt(indexS++) == bigger.charAt(index++)){
                tmpLength++;
            }
            maxLength = Math.max(maxLength, tmpLength);
            indexB = bigger.indexOf(symbol, indexB+1);
        }

        return maxLength;
    }


//    int longestCommonSubstring(String s, String t) {
//
//        int maxLengthSubString = 0;
//
//        String bigString;
//        String lessString;
//
//        if(s.length() < t.length()){
//            lessString = s;
//            bigString = t;
//        }else {
//            bigString = s;
//            lessString = t;
//        }
//        int bigLength = bigString.length();
//        int lessLength = lessString.length();
//        StringBuilder builder = new StringBuilder();
//
//        for (int i = 0; i < lessLength; i++){
//            if (lessLength - i <= maxLengthSubString){
//                break;
//            }
//            if (builder.indexOf(String.valueOf(lessString.charAt(i))) < 0) {
////                if (builder.indexOf(String.valueOf(lessString.charAt(i))) < 0) {
//
//                    int tmpMaxLengthSubString = 0;
//                char tmpChar = lessString.charAt(i);
//
//                for (int j = 0; j < bigLength; j++) {
//                    if (j < bigLength - tmpMaxLengthSubString) {
//                        int tmp = 0;
//                        if (bigString.charAt(j) == tmpChar) {
//
//                            int expLength = maxLengthSubString < tmpMaxLengthSubString ? tmpMaxLengthSubString : maxLengthSubString;
//                            tmp = findMaxLengthSubString(lessString, bigString, i, j, lessLength, bigLength, expLength);
//
//                        }
//                        if (tmp > tmpMaxLengthSubString) tmpMaxLengthSubString = tmp;
//                    } else break;
//                }
//
//                if (tmpMaxLengthSubString == 0){
//                    builder.append(tmpChar);
//                }
//                if (tmpMaxLengthSubString > maxLengthSubString) {
//                    maxLengthSubString = tmpMaxLengthSubString;
//                }
//            }
//        }
//
//        return maxLengthSubString;
//}
//
//
//    private int findMaxLengthSubString(String less, String big, int lessIndex, int bigIndex, int lengthLess, int lengthBig, int maxLength){
//
//        int lengthSubString = 0;
//        int maxSymbol;
//        if (lengthBig - bigIndex < lengthLess - lessIndex) {
//            maxSymbol = lessIndex + lengthBig - bigIndex;
//        } else {
//            maxSymbol = lengthLess - lessIndex;
//        }
//
//        if (maxSymbol < maxLength) return 0;
//
//        int i, j;
//
//            for (i = bigIndex, j = lessIndex; i < lengthBig && j < lengthLess; i++, j++) {
//
//                if (big.charAt(i) == less.charAt(j)) {
//                    lengthSubString++;
//                } else break;
//            }
//        return lengthSubString;
//
//    }

    int longestCommonSubstringTLE2(String s, String t) {

        if (s.length() == 1 || t.length() == 1) return 1;
        int maxLength = 0;
        String smaller;
        String bigger;

        if (s.length() <= t.length()){
            smaller = s;
            bigger = t;
        }else {
            smaller = t;
            bigger = s;
        }

        return stringContainString(smaller, bigger);
    }

    private int stringContainString(String smaller, String bigger){

        if (smaller.length() < 1) return 0;
        if (bigger.contains(smaller)) return smaller.length();

        return Math.max(stringContainString(smaller.substring(1), bigger), stringContainString(smaller.substring(0, smaller.length() - 1), bigger));
    }

    int longestCommonSubstring(String s, String t) {

        ArrayList<Integer> firstRow = new ArrayList<>(t.length()+1);
        for (int i = 0; i <= t.length(); i++){
            firstRow.add(0);
        }
        int maxLength = 0;
        for (int i = 1; i <= s.length(); i++){
            ArrayList<Integer> nextRow = new ArrayList<>(t.length()+1);
            nextRow.add(0);
            for (int j = 1; j <= t.length(); j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    nextRow.add(firstRow.get(j-1)+1);
                    maxLength = Math.max(maxLength, nextRow.get(j));
                }else {
                    nextRow.add(0);
                }
            }
            firstRow = nextRow;
        }

        return maxLength;
    }


    @Test
    public void test34(){

        Assert.assertEquals(longestCommonSubstring("d", "ivsinok"), 0);

        Assert.assertEquals(longestCommonSubstring("abcdxyz", "xyzabcd"), 4);
        Assert.assertEquals(longestCommonSubstring("zxabcdezy", "yzabcdezx"), 6);
        Assert.assertEquals(longestCommonSubstring("ABC", "ABCD"), 3);
        Assert.assertEquals(longestCommonSubstring("ABCD", "ABC"), 3);
        Assert.assertEquals(longestCommonSubstring("ABCDGH", "ACDGHR"), 4);
        Assert.assertEquals(longestCommonSubstring("EIYSBMRNOQSSFVOYXKEGLMAYGFG", "IHQZNAZGDMZQCPIUUDJ"), 1);


        int result = longestCommonSubstring("BAOPMDGZQMKQZXUVTQVNXBSLQZKGLZAMZPDNSJOLVYBWXXTTQOGNRBAIAKQLLSZKHF",
                "ZCONNMOQKLPEEFSNSMOUWQHODSGCFOHESYSHMGXWTOAYUVNOJDJFTQTWKBAPRIUJIMQWSPSLGVLCSAQBDBGWTBSEETTWDNFNBY");

        System.out.print(result);

    }
}
