package com.j2core.sts.leetcode.com.shortestWordDistanceIII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int shortestWordDistance(String[] words, String word1, String word2) {

        int indexStart = -1;
        int numWord = -1;
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++){
            int tmp;
            if (words[i].equals(word1)){
                tmp = 1;
            }else if (words[i].equals(word2)){
                tmp = 2;
            }else {
                tmp = 0;
            }
            if (tmp > 0){
                if (indexStart < 0){
                    indexStart = i;
                    numWord = tmp;
                }else {
                    if (numWord == 1){
                        if (words[i].equals(word2)){
                            delta = Math.min(delta, i-indexStart);
                            numWord = 2;
                        }
                    }else{
                        if (words[i].equals(word1)){
                            delta = Math.min(delta, i-indexStart);
                            numWord = 1;
                        }
                    }
                    indexStart = i;
                }
            }
        }

        return delta;
    }

    @Test
    public void test(){

        String[] list = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        Assert.assertEquals(shortestWordDistance(list, "makes", "coding"), 1);
        Assert.assertEquals(shortestWordDistance(list, "makes", "makes"), 3);


    }
}
