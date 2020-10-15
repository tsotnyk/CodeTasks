package com.j2core.sts.leetcode.com.verifyingAnAlienDictionary;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> letterOrder = createLetterMap(order);
        for (int i = 1; i < words.length; i++){
            if (secondWordSmaller(words[i-1], words[i], letterOrder)){
                return false;
            }
        }

        return true;
    }

    private boolean secondWordSmaller(String word1, String word2, Map<Character, Integer> letterOrder) {

        int index = 0;

        while (index < word1.length() && index < word2.length()){
            char first = word1.charAt(index);
            char second = word2.charAt(index);
            if (first == second){
                index++;
            }else {
                return letterOrder.get(second) < letterOrder.get(first);
            }
        }

        if (index < word1.length()) return true;
        return false;
    }

    private Map<Character, Integer> createLetterMap(String order){

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }

        return map;
    }

    @Test
    public void test(){

        Assert.assertTrue(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Assert.assertFalse(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        Assert.assertFalse(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));

    }
}
