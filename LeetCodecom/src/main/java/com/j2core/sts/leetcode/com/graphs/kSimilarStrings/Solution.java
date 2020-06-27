package com.j2core.sts.leetcode.com.graphs.kSimilarStrings;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int kSimilarity(String A, String B) {

        boolean[] visitedLetter = new boolean[A.length()];
        char[] aWord = A.toCharArray();

        for (int i = 0; i < A.length(); i++){
            if (aWord[i] == B.charAt(i)) visitedLetter[i] = true;
        }

        int swapCounter = 0;

        for (int j = 0; j < visitedLetter.length-1; j++){
            if (!visitedLetter[j] && aWord[j] != B.charAt(j)){
                int index = 0;
                while (visitedLetter[index] || aWord[index] != B.charAt(j)){
                    index++;
                }
                char tmp = aWord[j];
                aWord[j] = aWord[index];
                aWord[index] = tmp;
                swapCounter++;
                visitedLetter[j] = true;
            }
        }

        return swapCounter;
    }

    @Test
    public void test(){

        Assert.assertEquals(kSimilarity("ab", "ba"), 1);
        Assert.assertEquals(kSimilarity("abc", "bca"), 2);
        Assert.assertEquals(kSimilarity("abac", "baca"), 2);
        Assert.assertEquals(kSimilarity("aabc", "abca"), 2);

    }

}
