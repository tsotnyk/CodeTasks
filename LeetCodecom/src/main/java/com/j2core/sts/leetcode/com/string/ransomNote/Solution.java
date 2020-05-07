package com.j2core.sts.leetcode.com.string.ransomNote;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canConstructOld(String ransomNote, String magazine) {

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

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] array = new int[126];

        for (char character : magazine.toCharArray()){
            int letter = character;
            array[letter] += 1;
        }

        for (char character : ransomNote.toCharArray()){
            int letter = character;
            if (array[letter] == 0){
                return false;
            }else {
                array[letter] -= 1;
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
