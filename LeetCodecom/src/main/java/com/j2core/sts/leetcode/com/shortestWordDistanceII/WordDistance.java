package com.j2core.sts.leetcode.com.shortestWordDistanceII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordDistance {

    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {

        map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            List<Integer> list = map.getOrDefault(words[i], new LinkedList<>());
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int delta = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if (index1 < index2) {
                delta = Math.min(delta, index2 - index1);
                i++;
            } else {
                delta = Math.min(delta, index1 - index2);
                j++;
            }
        }

        return delta;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */