package com.j2core.sts.leetcode.com.reachingPoints;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);
    }


    @Test
    public void test(){

        Assert.assertFalse(reachingPoints(35,13,455955547, 420098884));
    }

}
