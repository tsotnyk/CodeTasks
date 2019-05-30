package com.j2core.sts.leetcode.com.substringwithConcatenationOfAllWords;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new LinkedList<>();

        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return result;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int totalLength = words.length;

        for(int i = 0; i < s.length() - wordLength * totalLength + 1; i++){

            HashMap<String, Integer> tmp = new HashMap<>();
            int index = 0;

            while(index < totalLength){
                String cur = s.substring(i + index * wordLength, i + (index + 1) * wordLength);
                if(map.containsKey(cur)){
                    tmp.put(cur, tmp.getOrDefault(cur, 0) + 1);
                    if(tmp.get(cur) > map.get(cur)){
                        break;
                    }
                }else{
                    break;
                }
                index++;
            }
            if(index == totalLength){
                result.add(i);
            }

        }
        return result;
    }

    @Test
    public void test(){

        String[] words = new String[]{"word","good","best","good"};
        List<Integer> result = findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake" , new String[]{"fooo","barr","wing","ding","wing"});

        Assert.assertEquals(2, result.size());

    }
}
