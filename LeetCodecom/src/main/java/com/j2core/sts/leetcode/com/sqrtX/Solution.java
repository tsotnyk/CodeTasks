package com.j2core.sts.leetcode.com.sqrtX;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int mySqrt(int x) {

        long l=0,r=x;
        while(l <= r){
            long mid=(int) ((l+r)/2);
            if(mid*mid<= x && ((mid+1)*(mid+1))> x){
                int ans= (int) mid;
                return ans;
            }
            else if(mid*mid > x){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return 1;
    }

    @Test
    public void test(){

//        Assert.assertEquals(mySqrt(4), 2);
        Assert.assertEquals(mySqrt(8), 2);
        Assert.assertEquals(mySqrt(56), 7);
        Assert.assertEquals(mySqrt(14900), 122);

    }
}
