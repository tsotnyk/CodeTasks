package com.j2core.sts.leetcode.com.string.numberOfGoodWaysToSplitString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Solution {

    public int numSplits(String s) {

        int[] matrix = new int[s.length()];
        HashSet<Character> charSet = new HashSet<>();

        for (int i = 0; i < s.length()-1; i++){
            charSet.add(s.charAt(i));
            matrix[i] = charSet.size();
        }

        charSet = new HashSet<>();
        int counter = 0;

        for (int i = s.length()-1; i > 0; i--){
            charSet.add(s.charAt(i));
            if (matrix[i-1] == charSet.size()){
                counter++;
            }
        }
        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(numSplits("acbadbaada"), 2);
        Assert.assertEquals(numSplits("aaaaa"), 4);
        Assert.assertEquals(numSplits("abcd"), 1);
        Assert.assertEquals(numSplits("aacaba"), 2);

    }
}
