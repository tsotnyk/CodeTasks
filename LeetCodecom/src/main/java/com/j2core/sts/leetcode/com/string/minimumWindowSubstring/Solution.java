package com.j2core.sts.leetcode.com.string.minimumWindowSubstring;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int minIndexStart = -1;
        int minIndexEnd = -1;
        int indexStart = 0;
        int indexEnd = t.length();
        Map<Character, Integer> baseMap = createCharMap(t);
        Map<Character, Integer> map = createCharMap(s.substring(indexStart, indexEnd));

        while (indexEnd < s.length() || indexStart+t.length() < s.length()){
            if (containAllCharacters(baseMap, map)){
                if (minIndexEnd == -1){
                    minIndexEnd = indexEnd;
                    minIndexStart = indexStart;
                }else {
                    if(indexEnd-indexStart < minIndexEnd-minIndexStart){
                        minIndexEnd = indexEnd;
                        minIndexStart = indexStart;
                    }
                }
                char tmp = s.charAt(indexStart++);
                if (map.get(tmp) > 1){
                    map.put(tmp, map.get(tmp)-1);
                }else {
                    map.remove(tmp);
                }
            }else {
                if (indexEnd < s.length()) {
                    char tmp = s.charAt(indexEnd++);
                    if (map.containsKey(tmp)) {
                        map.put(tmp, map.get(tmp) + 1);
                    } else {
                        map.put(tmp, 1);
                    }
                }else {
                    char tmp = s.charAt(indexStart++);
                    if (map.get(tmp) > 1){
                        map.put(tmp, map.get(tmp)-1);
                    }else {
                        map.remove(tmp);
                    }
                }
            }
        }

        if (containAllCharacters(baseMap, map)){
            if (minIndexEnd == -1){
                minIndexEnd = indexEnd;
                minIndexStart = indexStart;
            }else {
                if(indexEnd-indexStart < minIndexEnd-minIndexStart){
                    minIndexEnd = indexEnd;
                    minIndexStart = indexStart;
                }
            }
        }

        return minIndexEnd > -1 ? s.substring(minIndexStart, minIndexEnd) : "";
    }

    private boolean containAllCharacters(Map<Character, Integer> baseMap, Map<Character, Integer> map){

        for (char symbol : baseMap.keySet()){
            if (baseMap.get(symbol) > map.getOrDefault(symbol, 0)){
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> createCharMap(String string){

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++){
            char tmp = string.charAt(i);
            if (map.containsKey(tmp)){
                map.put(tmp, map.get(tmp)+1);
            }else {
                map.put(tmp, 1);
            }
        }

        return map;
    }

    @Test
    public void test(){

//        Assert.assertEquals(minWindow("ADOBECODEBANC", "ABC"), "BANC");
        Assert.assertEquals(minWindow("ab", "A"), "");

    }
}
