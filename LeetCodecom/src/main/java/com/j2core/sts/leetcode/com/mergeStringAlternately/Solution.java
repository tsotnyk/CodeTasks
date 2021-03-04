package com.j2core.sts.leetcode.com.mergeStringAlternately;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder builder = new StringBuilder();
        int index1 = 0;
        int index2 = 0;

        while (index1 < word1.length() && index2 < word2.length()){
            builder.append(word1.charAt(index1++)).append(word2.charAt(index2++));
        }

        if (index1 < word1.length()){
            builder.append(word1.substring(index1));
        }
        if (index2 < word2.length()){
            builder.append(word2.substring(index2));
        }

        return builder.toString();
    }

    String palindromeCutting(String s) {

        for(int i = s.length()-1; i > 0; i--){
            if(isPalindronm(s, i)){
                return palindromeCutting(s.substring(i+1));
            }
        }

        return s;
    }

    boolean isPalindronm(String s, int indexR){

        int indexL = 0;

        while(indexL <indexR){
            if(s.charAt(indexL++) != s.charAt(indexR--)) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals("", palindromeCutting("aaacodedoc"));
    }
}
