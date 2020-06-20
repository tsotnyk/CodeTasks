package com.j2core.sts.leetcode.com.hackerrank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution2 {

    public static List<String> mostActive(List<String> customers) {
        // Write your code here

        double percentile = (customers.size()/100.0)*5.0;
        int minValue;
        if (percentile%1 != 0){
            minValue = (int) percentile + 1;
        }else {
            minValue = (int) percentile;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String name : customers){
            map.put(name, map.getOrDefault(name, 0)+1);
        }

        List<String> nameList = new ArrayList<>();

        for (Map.Entry<String, Integer> person : map.entrySet()){
            if (person.getValue() >= minValue){
                nameList.add(person.getKey());
            }
        }

        Collections.sort(nameList);
        return nameList;
    }

    @Test
    public void test(){

        ArrayList<String> list = new ArrayList<>();
        list.add("4");
        list.add("25");
        list.add("-30");
        list.add("70");
        list.add("10");
        Assert.assertEquals(mostActive(list).size(), 2);
    }
}
