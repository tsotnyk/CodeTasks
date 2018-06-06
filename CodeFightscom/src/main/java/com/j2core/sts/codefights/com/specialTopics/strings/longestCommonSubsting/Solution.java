package com.j2core.sts.codefights.com.specialTopics.strings.longestCommonSubsting;

import org.testng.annotations.Test;

public class Solution {

    int longestCommonSubstring(String s, String t) {

        int maxLengthSubString = 0;

        String bigString;
        String lessString;

        if(s.length() < t.length()){
            lessString = s;
            bigString = t;
        }else {
            bigString = s;
            lessString = t;
        }
        int bigLength = bigString.length();
        int lessLength = lessString.length();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < lessLength; i++){
            if (lessLength - i <= maxLengthSubString){
                break;
            }
            if (builder.indexOf(String.valueOf(lessString.charAt(i))) < 0) {
//                if (builder.indexOf(String.valueOf(lessString.charAt(i))) < 0) {

                    int tmpMaxLengthSubString = 0;
                char tmpChar = lessString.charAt(i);

                for (int j = 0; j < bigLength; j++) {
                    if (j < bigLength - tmpMaxLengthSubString) {
                        int tmp = 0;
                        if (bigString.charAt(j) == tmpChar) {

                            int expLength = maxLengthSubString < tmpMaxLengthSubString ? tmpMaxLengthSubString : maxLengthSubString;
                            tmp = findMaxLengthSubString(lessString, bigString, i, j, lessLength, bigLength, expLength);

                        }
                        if (tmp > tmpMaxLengthSubString) tmpMaxLengthSubString = tmp;
                    } else break;
                }

                if (tmpMaxLengthSubString == 0){
                    builder.append(tmpChar);
                }
                if (tmpMaxLengthSubString > maxLengthSubString) {
                    maxLengthSubString = tmpMaxLengthSubString;
                }
            }
        }

        return maxLengthSubString;
}


    private int findMaxLengthSubString(String less, String big, int lessIndex, int bigIndex, int lengthLess, int lengthBig, int maxLength){

        int lengthSubString = 0;
        int maxSymbol;
        if (lengthBig - bigIndex < lengthLess - lessIndex) {
            maxSymbol = lessIndex + lengthBig - bigIndex;
        } else {
            maxSymbol = lengthLess - lessIndex;
        }

        if (maxSymbol < maxLength) return 0;

        int i, j;

            for (i = bigIndex, j = lessIndex; i < lengthBig && j < lengthLess; i++, j++) {

                if (big.charAt(i) == less.charAt(j)) {
                    lengthSubString++;
                } else break;
            }
        return lengthSubString;

    }


    @Test
    public void test34(){

        int result = longestCommonSubstring("BAOPMDGZQMKQZXUVTQVNXBSLQZKGLZAMZPDNSJOLVYBWXXTTQOGNRBAIAKQLLSZKHF",
                "ZCONNMOQKLPEEFSNSMOUWQHODSGCFOHESYSHMGXWTOAYUVNOJDJFTQTWKBAPRIUJIMQWSPSLGVLCSAQBDBGWTBSEETTWDNFNBY");

        System.out.print(result);

    }
}
