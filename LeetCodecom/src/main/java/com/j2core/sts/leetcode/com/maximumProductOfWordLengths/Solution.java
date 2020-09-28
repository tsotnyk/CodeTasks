package com.j2core.sts.leetcode.com.maximumProductOfWordLengths;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxProduct(String[] words) {

        int maxLength = 0;
        int tmpLength;

        for (int i =0; i < words.length-1; i++){

            for (int j = i+1; j < words.length; j++){
                tmpLength = 0;

                if (isAllUniqCharacters(words[i], words[j])){
                    tmpLength = words[i].length() * words[j].length();
                }

                maxLength = Math.max(maxLength, tmpLength);
            }
        }

        return maxLength;
    }

    private boolean isAllUniqCharacters(String word1, String word2){

        boolean[] matrix = new boolean[26];

        for (int i = 0; i < word1.length(); i++){
            matrix[word1.charAt(i)-'a'] = true;
        }
        for (int i = 0; i < word2.length(); i++){
            if (matrix[word2.charAt(i)-'a']) return false;
        }
        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}), 16);
        Assert.assertEquals(maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}), 4);
        Assert.assertEquals(maxProduct(new String[]{"a","aa","aaaaaaaa","aaa"}), 0);
    }
}
