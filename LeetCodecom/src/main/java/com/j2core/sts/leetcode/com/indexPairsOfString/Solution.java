package com.j2core.sts.leetcode.com.indexPairsOfString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int[][] indexPairs(String text, String[] words) {

        int minLength = 20;
        int maxLength = 1;
        HashSet<String> wordSet = new HashSet<>();

        for (String word : words){
            wordSet.add(word);
            minLength = Math.min(word.length(), minLength);
            maxLength = Math.max(word.length(), maxLength);
        }

        ArrayList<int[]> pairList = new ArrayList<>();

        for (int i = 0; i <= text.length()-minLength; i++){
            for (int j = i+1; j <= text.length() && j <= i+maxLength; j++){
                if(wordSet.contains(text.substring(i, j))){
                    pairList.add(new int[]{i, j-1});
                }
            }
        }

        return pairList.toArray(new int[pairList.size()][2]);
    }

    @Test
    public void test(){

        Assert.assertEquals(indexPairs("thestoryofleetcodeandme", new String[]{"story","fleet","leetcode"}).length, 3);
        Assert.assertEquals(indexPairs("ababa", new String[]{"aba","ab"}).length, 4);

    }
}
