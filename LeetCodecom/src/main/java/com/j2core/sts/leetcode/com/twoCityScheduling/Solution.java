package com.j2core.sts.leetcode.com.twoCityScheduling;

import java.util.Arrays;

public class Solution {

    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) -  (b[0] - b[1]));
        for(int i = 0; i < costs.length; i++){
            if(i < costs.length / 2){
                res += costs[i][0];
            }else{
                res += costs[i][1];
            }
        }
        return res;
    }
}
