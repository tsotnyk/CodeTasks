package com.j2core.sts.leetcode.com.pathInZigzagLabelledBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> result = new LinkedList<>();

        if(label <= 0){
            return result;
        }

        int level = 0, sum = 1;
        result.add(label);

        while(label >= sum){
            sum *=2;
            level++;
        }

        sum /= 2;
        level--;

        while(level>=0){
            int temp = label - sum;
            sum /=2;
            label = label - temp - temp/2 -1;
            level--;
            if(label > 0){
                result.add(0, label);
            }
        }
        return result;
    }
}
