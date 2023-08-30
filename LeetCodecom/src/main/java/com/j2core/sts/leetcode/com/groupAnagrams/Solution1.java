package com.j2core.sts.leetcode.com.groupAnagrams;

import java.util.*;

public class Solution1 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs){

            char[] charAr = word.toCharArray();
            Arrays.sort(charAr);
            String sortWord = new String(charAr);

            List<String> list = map.getOrDefault(sortWord, new LinkedList<>());
            list.add(word);
            map.put(sortWord, list);
        }

        List<List<String>> res = new LinkedList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }
}
