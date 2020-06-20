package com.j2core.sts.leetcode.com.hackerrank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public  int getBattery(List<Integer> events) {
        // Write your code here
        int value = 50;

        for (int i = 1; i < events.size(); i++){

            value += events.get(i);
            if (value > 100) value = 100;
        }

        return value;
    }

    @Test
    public void test(){

        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(25);
        list.add(-30);
        list.add(70);
        list.add(-10);

        Assert.assertEquals(getBattery(list), 90);
    }
}
