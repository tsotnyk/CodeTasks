package com.j2core.sts.leetcode.com.string.minimumWindowSubstring;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String minWindowOld(String s, String t) {

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

    public String minWindow(String s, String t) {

        if (s.length() == t.length()) return equalsString(s, t) ? s : "";
        if (s.length() < t.length()) return "";

        String result = "";

        int indexStart = 0;
        int index = t.length();
        String tmpStr = s.substring(indexStart, index);
        Map<Character, Integer> tMap = createCharMap(t);
        Map<Character, Integer> sBase = createCharMap(tmpStr);

        while (indexStart <= s.length()-t.length()){
            if (containString(sBase, tMap)){
                if (result.length() == 0){
                    result = tmpStr;
                }else {
                    result = result.length() > tmpStr.length() ? tmpStr : result;
                }
                sBase.put(s.charAt(indexStart), sBase.get(s.charAt(indexStart))-1);
                indexStart++;
                if (indexStart < s.length()) {
                    index = indexStart == index ? ++index : index;
                    tmpStr = s.substring(indexStart, index);
                }
            }else {
                if (index < s.length()) {
                    sBase.put(s.charAt(index), sBase.getOrDefault(s.charAt(index), 0) + 1);
                    index++;
                    tmpStr = s.substring(indexStart, index);
                }else{
                    indexStart++;
                }
            }
        }

        return result;
    }

    private boolean containString(Map<Character, Integer> sBase, Map<Character, Integer> tMap){

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()){
            int tmp = sBase.getOrDefault(entry.getKey(), -1);
            if (tmp == -1 || tmp < entry.getValue()){
                return false;
            }
        }
        return true;
    }

    private boolean equalsString(String s, String t){

        int[] array = new int[126];
        for (int i = 0; i < s.length(); i++){
            array[s.charAt(i)] += 1;
        }
        for (int j = 0; j < t.length(); j++){
            if (array[t.charAt(j)] == 0){
                return false;
            }else {
                array[t.charAt(j)] -= 1;
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(minWindow("babb", "baba"), "");

        Assert.assertEquals(minWindow("ab", "b"), "b");

        Assert.assertEquals(minWindow("bbaa", "aba"), "baa");
        Assert.assertEquals(minWindow("abc", "cba"), "abc");

        Assert.assertEquals(minWindow("ab", "a"), "a");
        Assert.assertEquals(minWindow("ADOBECODEBANC", "ABC"), "BANC");
        Assert.assertEquals(minWindow("ab", "A"), "");

    }
}
