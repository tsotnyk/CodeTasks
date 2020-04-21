package com.j2core.sts.leetcode.com.fruitIntoBasket;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int totalFruit(int[] tree) {

        int sum = 0;
        int index = 0;
        int index1 = 0;
        int index2 = 0;

        while (index < tree.length) {
            while (index < tree.length && tree[index] == tree[index1]) {
                index++;
            }
            index2 = index;

            while (index < tree.length && (tree[index] == tree[index1] || tree[index] == tree[index2])) {
                index++;
            }
            sum = Math.max(sum, index - index1);
            index1 = index2;
            index = index1 + 1;
            if (tree.length - index1 <= sum) break;
        }

        return sum;
    }

    @Test
    public void test(){


        Assert.assertEquals(totalFruit(new int[]{1,2,1}), 3);
        Assert.assertEquals(totalFruit(new int[]{0,1,2,2}), 3);
        Assert.assertEquals(totalFruit(new int[]{1,2,3,2,2}), 4);
        Assert.assertEquals(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}), 5);

    }
}
