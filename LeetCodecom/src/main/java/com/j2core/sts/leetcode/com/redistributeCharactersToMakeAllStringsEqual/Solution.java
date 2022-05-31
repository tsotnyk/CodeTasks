package com.j2core.sts.leetcode.com.redistributeCharactersToMakeAllStringsEqual;

import java.util.HashMap;

public class Solution {

    public boolean makeEqual(String[] words) {

        int allLength = 0;

        for (String word : words){
            allLength += word.length();
        }

        if (allLength% words.length != 0) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char symbol : words[0].toCharArray()){
            map.put(symbol, map.getOrDefault(symbol, 0)+1);
        }

        for (int i = 1; i < words.length; i++){
            if (words[i-1].length() == words[i].length() && !words[i-1].equals(words[i])){
                return false;
            }
            if (Math.abs(words[i-1].length()- words[i].length()) > 1) return false;

            

        }

        return true;
    }
}
