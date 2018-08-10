package com.j2core.sts.leetcode.com.positionsOfLargeGroups;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new LinkedList<>();
        int firstIndex = 0;
        int lastIndex = 0;

        char tmpChar = S.charAt(0);
        for(int i = 1; i < S.length(); i++){

            if(tmpChar != S.charAt(i)){

                if(lastIndex - firstIndex + 1 >= 3){
                    List<Integer> tmpResult = new LinkedList<>();
                    tmpResult.add(firstIndex);
                    tmpResult.add(lastIndex);
                    result.add(tmpResult);

                }

                firstIndex = i;
                tmpChar = S.charAt(i);
            }

            lastIndex = i;

        }

        if(lastIndex - firstIndex >= 3 - 1){

            List<Integer> tmpResult = new LinkedList<>();
            tmpResult.add(firstIndex);
            tmpResult.add(lastIndex);
            result.add(tmpResult);
        }

        return result;
    }


    @Test
    public void test(){

        List<List<Integer>> result = largeGroupPositions("abbxxxxzzy");

        Assert.assertEquals(result.size(), 1);

    }
}
