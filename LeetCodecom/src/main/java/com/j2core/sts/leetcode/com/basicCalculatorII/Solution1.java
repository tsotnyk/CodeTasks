package com.j2core.sts.leetcode.com.basicCalculatorII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int calculate(String s) {

        return 0;
        
    }

    @Test
    public void test(){

        Assert.assertEquals(calculate("3+2*2"), 7);
        Assert.assertEquals(calculate(" 3/2"), 1);
        Assert.assertEquals(calculate(" 3+5 / 2"), 5);

    }
}
