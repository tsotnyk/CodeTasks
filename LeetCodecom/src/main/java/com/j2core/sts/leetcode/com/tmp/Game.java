package com.j2core.sts.leetcode.com.tmp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Game {

    public int recursionGumpGame(int n, int k){


        int sum = 0;
        for (int i = 1; i <= Math.min(n, k); i++){
            if (i == n) sum++; else
                sum += recursionGumpGame(n-i, k);
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(recursionGumpGame(3,2), 3);
        Assert.assertEquals(recursionGumpGame(1,2), 1);
        Assert.assertEquals(recursionGumpGame(2,2), 2);
        Assert.assertEquals(recursionGumpGame(3,2), 3);
        Assert.assertEquals(recursionGumpGame(4,2), 5);
        Assert.assertEquals(recursionGumpGame(5,2), 8);
        Assert.assertEquals(recursionGumpGame(6,2), 13);



    }
}
