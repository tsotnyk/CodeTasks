package com.j2core.sts.leetcode.com.buildArrayWithStackOperations;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> buildArray(int[] target, int n) {

        if (target == null) return null;
        if (target.length == 0) return new LinkedList<>();

        int index = 0;
        int num = 1;
        List<String> result = new LinkedList<>();

        while (index < target.length){
            result.add("Push");
            if (num < target[index]){
                result.add("Pop");
            }else {
                index++;
            }
            num++;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(buildArray(new int[]{1,3}, 3), new LinkedList<>(Arrays.asList("Push", "Push", "Pop", "Push")));
        Assert.assertEquals(buildArray(new int[]{1,2}, 3), new LinkedList<>(Arrays.asList("Push", "Push")));
        Assert.assertEquals(buildArray(new int[]{1,2,3}, 3), new LinkedList<>(Arrays.asList("Push", "Push","Push")));

    }

}
