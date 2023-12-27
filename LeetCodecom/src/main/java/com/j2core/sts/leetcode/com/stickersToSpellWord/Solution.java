package com.j2core.sts.leetcode.com.stickersToSpellWord;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public int minStickers(String[] stickers, String target) {

        var targetMap = createCharArray(target);

        HashMap<Character, List<Map<Character, Integer>>> stickersMap = new HashMap<>();
        for (String sticker : stickers){
            var curMap = createCharArray(sticker);
            for (char key : curMap.keySet()){

                    List<Map<Character, Integer>> list = stickersMap.getOrDefault(key, new LinkedList<>());
                    list.add(curMap);
                    stickersMap.put(key, list);

            }
        }

        return helper(targetMap, stickersMap, 0);
    }

    private int helper(Map<Character, Integer> targetMap, HashMap<Character, List<Map<Character, Integer>>> stickersMap, int counter) {

        int minCounter = Integer.MAX_VALUE;
        boolean flag = true;

        for (char sym : targetMap.keySet()){
            if (targetMap.get(sym) <= 0) continue;
            if (!stickersMap.containsKey(sym)) return -1;
            flag = false;
            for (Map<Character, Integer> curSticker : stickersMap.get(sym)){
                addSticker(targetMap, curSticker);
                minCounter = Math. min(minCounter, helper(targetMap, stickersMap, counter+1));
                removeSticker(targetMap,curSticker);
            }
        }

        return flag ? counter : minCounter;
    }

    private void removeSticker(Map<Character, Integer> targetMap, Map<Character, Integer> curSticker) {

        for (char key : targetMap.keySet()){
            targetMap.put(key, targetMap.get(key) + curSticker.getOrDefault(key, 0));
        }
    }

    private void addSticker(Map<Character, Integer> targetMap, Map<Character, Integer> curSticker) {

        for (char key : targetMap.keySet()){
            targetMap.put(key, targetMap.get(key) - curSticker.getOrDefault(key, 0));
        }
    }

    private Map<Character, Integer> createCharArray(String word) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char sym : word.toCharArray()){
            map.put(sym, map.getOrDefault(sym, 0)+1);
        }

        return map;
    }

    @Test
    public void test(){

        Assert.assertEquals(minStickers(new String[]{"with","example","science"}, "thehat"), 3);
    }

}
