package com.j2core.sts.leetcode.com.hackerrank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {

    public static int minOperations(List<Integer> arr, int threshold, int d) {
        // Write your code here

        int arraySum, smallest, arr_size = arr.size();
        arraySum = 0;
        smallest = arr.get(0);
        for (int i = 0; i < arr_size ; i ++)
        {
            /* If current element is smaller than
               update smallest */
            if (arr.get(i) < smallest)
                smallest = arr.get(i);

            /*find array sum */
            arraySum += arr.get(i);
        }

        int minOperation = arraySum - arr_size * smallest;

        return minOperation;
    }

    @Test
    public void test(){

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

        Assert.assertEquals(minOperations(list, 3, 2), 2);
    }
}
