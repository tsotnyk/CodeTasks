package com.j2core.sts.leetcode.com.groupShiftedStrings;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<List<String>> groupStrings(String[] strings) {

        HashMap<String, List<String>> map = createMap(strings);

        List<List<String>> res = new LinkedList<>();
        for (String key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }

    private HashMap<String, List<String>> createMap(String[] strings) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strings){

            StringBuilder key = new StringBuilder();

            char base = word.charAt(0);
            for (char sym : word.toCharArray()){

                int diff = sym - base;
                if (diff < 0)  diff += 26;
                key.append(diff).append('*');
            }

            List<String> list = map.getOrDefault(key.toString(), new LinkedList<>());
            list.add(word);
            map.put(key.toString(), list);
        }

        return map;
    }

    @Test
    public void test(){

        int dif = 'z' - 'a';
        int diff = 'a' - 'b';

        System.out.println("*");
    }

}
