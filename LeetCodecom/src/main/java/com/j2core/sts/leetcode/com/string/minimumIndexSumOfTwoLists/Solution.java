package com.j2core.sts.leetcode.com.string.minimumIndexSumOfTwoLists;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> list1Map = createNameMap(list1);
        Map<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < list2.length; i++){

            String tmp = list2[i];

            if (list1Map.containsKey(tmp)){
                resultMap.put(tmp, list1Map.get(tmp)+i);
            }

        }

        int minSum = Integer.MAX_VALUE;
        List<String> result = new LinkedList<>();

        for (int i=0;i<list2.length;i++) {
            Integer j = resultMap.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) {
                    result.clear(); minSum = i+j;
                }
                result.add(list2[i]);
            }
        }

        String[] ret = new String[result.size()];
        int i=0;
        for(String s : result) ret[i++] = s;

        return ret;
    }

    private Map<String, Integer> createNameMap(String[] list){

        Map<String, Integer> listMap = new HashMap<>();

        for (int i = 0; i < list.length; i++){

            listMap.put(list[i], i);

        }

        return listMap;
    }


    @Test
    public void test(){

        String[] result = findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},new String[] {"KFC","Shogun","Burger King"});

        Assert.assertTrue(result.length == 1);

    }
}
