package com.j2core.sts.leetcode.com.minimumNumberOfDaysToEatNOranges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    private HashMap<Integer,Integer> mp = new HashMap<>();
    public int minDaysRecursion(int n) {
        if(n <= 2)
            return n;
        if(mp.containsKey(n))
            return mp.get(n);

        mp.put(n, 1 + Math.min(n % 2 + minDays(n/2), n % 3 + minDays(n/3)));
        return mp.get(n);
    }

    public int minDaysArray(int n) {

        int[] dp = new int[n+1];
        int index;
        for (int i = 1; i <= n; i++){
            if (i%3 == 0 && i%2 == 0){
                int minDays = Math.min(dp[i-(2*(i/3))], dp[i-(i/2)]);
                dp[i] = 1+ Math.min(minDays, dp[i-1]);
            }else if (i%3 == 0){
                index = i-(2*(i/3));
                dp[i] = 1+ Math.min(dp[i-1], dp[index]);
            }else if (i%2 == 0){
                index = i-(i/2);
                dp[i] = 1 + Math.min(dp[i-1], dp[index]);
            }else {
                dp[i] = 1+dp[i-1];
            }
        }

        return dp[n];
    }

    public int minDays(int n) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int index;
        for (int i = 1; i <= n; i++){
            if (i%3 == 0 && i%2 == 0){
                int minDays = Math.min(list.get(i-(2*(i/3))), list.get(i-(i/2)));
                list.add( 1 + Math.min(list.get(i-1), minDays));
            }else if (i%3 == 0){
                index = i-(2*(i/3));
                list.add( 1 + Math.min(list.get(i-1), list.get(index)));
            }else if (i%2 == 0){
                index = i-(i/2);
                list.add( 1 + Math.min(list.get(i-1), list.get(index)));
            }else {
                list.add(list.get(i-1)+1);
            }
        }

        return list.get(n);
    }

    @Test
    public void test(){
        Assert.assertEquals(minDays(61455274), 29);
        Assert.assertEquals(minDays(84806671),32);
        Assert.assertEquals(minDays(182),8);
        Assert.assertEquals(minDays(10),4);
        Assert.assertEquals(minDays(6),3);
        Assert.assertEquals(minDays(1),1);
        Assert.assertEquals(minDays(56),6);

    }
}
