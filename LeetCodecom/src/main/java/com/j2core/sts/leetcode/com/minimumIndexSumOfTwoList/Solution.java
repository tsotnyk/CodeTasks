package com.j2core.sts.leetcode.com.minimumIndexSumOfTwoList;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> set1 = new HashMap<>();

        for (int i = 0; i < list1.length; i++){
            set1.put(list1[i], i);
        }

        int sumIndex = Integer.MAX_VALUE;
        List<String> restList = null;

        int index = 0;
        for (String rest : list2){
            if (set1.containsKey(rest)){
                int tmpSum = index+set1.get(rest);
                if (sumIndex == tmpSum) {
                    restList.add(rest);
                }else if (sumIndex > tmpSum){
                    restList = new LinkedList<>(Collections.singletonList(rest));
                    sumIndex = tmpSum;
                }
            }
            index++;
        }

        String[] result = new String[restList.size()];
        index = 0;
        for (String rest : restList){
            result[index++] = rest;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertArrayEquals(new String[]{"Sh"}, findRestaurant(new String[]{"Sh", "Tap", "Bur", "KFC"},
                new String[]{"KFC", "Sh", "Bur"}));
        Assert.assertArrayEquals(new String[]{"KFC","Bur","Tap","Sh"}, findRestaurant(new String[]{"Sh", "Tap", "Bur", "KFC"},
                new String[]{"KFC", "Bur", "Tap", "Sh"}));
    }
}
