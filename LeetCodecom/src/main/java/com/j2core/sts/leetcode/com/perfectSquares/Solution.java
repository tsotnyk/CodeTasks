package com.j2core.sts.leetcode.com.perfectSquares;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int numSquares(int n) {

        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }

        return dp[n];
    }

    public int numSquaresNo(int n) {

//        ArrayList<Integer> squares = new ArrayList<>();
//
//        int num = 2;
//        int square = 1;
//        while (square < n){
//            squares.add(square);
//            square = num * num++;
//        }

        int counter = 0;
//        int index = squares.size()-1;
//
//        while (n != 0){
//            if (n-squares.get(index) >= 0){
//                n -= squares.get(index);
//                counter++;
//            }else {
//                index--;
//            }
//        }
        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(numSquares(12), 3);
        Assert.assertEquals(numSquares(13), 2);
    }
}
