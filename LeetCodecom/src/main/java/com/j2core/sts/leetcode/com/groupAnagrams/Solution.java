package com.j2core.sts.leetcode.com.groupAnagrams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : strs){

            char[] array = word.toCharArray();
            Arrays.sort(array);
            String base = new String(array);
            if (anagrams.containsKey(base)){

                anagrams.get(base).add(word);

            }else {

                List<String> list = new ArrayList<>();
                list.add(word);
                anagrams.put(base, list);
            }

        }

        return new ArrayList<>(anagrams.values());

    }


    @Test
    public void test(){

        List<List<String>> result = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        Assert.assertTrue(result.size() == 3);

    }

}
