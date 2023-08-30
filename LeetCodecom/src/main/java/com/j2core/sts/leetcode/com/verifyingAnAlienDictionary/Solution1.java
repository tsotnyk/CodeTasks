package com.j2core.sts.leetcode.com.verifyingAnAlienDictionary;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution1 {

    public boolean isAlienSorted(String[] words, String order) {

        HashMap<Character, Integer> orderMap = createOrderMap(order);

        for (int i = 1; i < words.length; i++){
            int index = 0;
            char first = words[i-1].charAt(index);
            char second = words[i].charAt(index++);
            while (index < words[i-1].length() && index < words[i].length() && first == second){
                first = words[i-1].charAt(index);
                second= words[i].charAt(index++);
            }

            if (first == second){
                if (words[i-1].length() > words[i].length()) return false;
            }

            if (orderMap.get(first) > orderMap.get(second)) return false;
        }

        return true;
    }

    private HashMap<Character, Integer> createOrderMap(String order){

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++){

            map.put(order.charAt(i), i);
        }

        return map;
    }

    @Test
    public void test(){

        Assert.assertTrue(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Assert.assertFalse(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        Assert.assertFalse(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));

    }
}
