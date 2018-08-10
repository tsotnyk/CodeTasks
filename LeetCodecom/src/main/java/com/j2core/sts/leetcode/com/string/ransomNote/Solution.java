package com.j2core.sts.leetcode.com.string.ransomNote;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> map=new HashMap<>();

        for(char character : magazine.toCharArray()){

            map.put(character,map.getOrDefault(character,0)+1);
        }
        for(char character :ransomNote.toCharArray()){
            if(!map.containsKey(character)) {

                return false;
            } else {
                map.put(character, map.get(character) - 1);
            }

            if(map.get(character)==0) {
                map.remove(character);
            }
        }
        return true;
    }


    @Test
    public void test(){

        boolean result = canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh");

        Assert.assertTrue(result);
    }

}
