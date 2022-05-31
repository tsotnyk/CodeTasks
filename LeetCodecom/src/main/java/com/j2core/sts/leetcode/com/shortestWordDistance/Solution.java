package com.j2core.sts.leetcode.com.shortestWordDistance;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int minDist = wordsDict.length;
        int index1 = 0;

        while (index1 < wordsDict.length){

            if (!wordsDict[index1].equals(word1)){
                index1++;
                continue;
            }
            int index = wordsDict.length-1;
            while (index > -1) {
                if (!wordsDict[index].equals(word2)) {
                    index--;
                    continue;
                }
                minDist = Math.min(minDist, Math.abs(index-- - index1));
            }
            index1++;
        }

        return minDist;
    }

    @Test
    public void test(){

        Assert.assertEquals(3, shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
    }
}
