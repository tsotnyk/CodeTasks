package com.j2core.sts.leetcode.com.hackerrank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution5 {

    public static int filledOrders(List<Integer> order, int k) {
        // Write your code here
        long sum = 0;

        for (int num : order){
            sum += num;
        }

        if (sum <= k) return order.size();

        Collections.sort(order);
        int maxOrder = order.size();
        for (int i = order.size()-1; i > -1; i--){
            sum -= order.get(i);
            maxOrder--;
            if (sum <= k) return maxOrder;
        }

        return 0;
    }

    @Test
    public void test(){

//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 30));
//        Assert.assertEquals(filledOrders(list, 40), 2);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5,4,6));
        Assert.assertEquals(filledOrders(list2, 3), 0);

    }
}
