package com.j2core.sts.leetcode.com.nestedListWeightSum;

import java.util.List;

public class Solution {

    public int depthSum(List<NestedInteger1> nestedList) {

        int sum = 0;
        for (NestedInteger1 nestedInteger : nestedList){
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger();
                continue;
            }
            sum += calculate(2, nestedInteger);
            }

        return sum;
        }


    private int calculate(int level, NestedInteger1 num) {

        if (num.isInteger()) return num.getInteger()*level;
        int sum = 0;
        for (NestedInteger1 nextNum : num.getList()){
            if (nextNum.isInteger()){
                sum += nextNum.getInteger()*level;
                continue;
            }
            sum += calculate(level+1, nextNum);
        }

        return sum;
    }


}
