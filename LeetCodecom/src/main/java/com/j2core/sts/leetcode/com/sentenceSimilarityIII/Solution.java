package com.j2core.sts.leetcode.com.sentenceSimilarityIII;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Solution {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        HashMap<String, Integer> map = new HashMap<>();
        String[] array1 = sentence1.split(" ");
        String[] array2 = sentence2.split(" ");

        for (String word : array1){

            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for (String word : array2){

            int counter = map.getOrDefault(word, 0);
            if (counter > 0){
                map.put(word, counter-1);
            }else {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(areSentencesSimilar("Eating right now", "Eating"));
    }
}
