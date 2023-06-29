package com.j2core.sts.leetcode.com;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Combination {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new LinkedList<>();

        helper(new LinkedList<>(), result, 1, n, k);

        return result;
    }

    public void helper(List<Integer> curList, List<List<Integer>> result, int number, int maxNumber, int k){

        if (k == 0){
            result.add(curList);
            return;
        }

        for (int i = number; i <= maxNumber; i++){
            List<Integer> newList = new LinkedList<>(curList);
            newList.add(i);
            helper(newList, result, i+1, maxNumber, k-1);
        }
    }

    @Test
    public void test(){

        List<List<Integer>> result1 = combine(1,1);
        List<List<Integer>> result2 = combine(4,2);
        List<List<Integer>> result3 = combine(4,3);

        Assert.assertEquals(result1.size(), 1);
        Assert.assertEquals(result2.size(), 6);
        Assert.assertEquals(result3.size(), 4);

    }
}
