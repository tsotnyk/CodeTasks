package com.j2core.sts.leetcode.com.pascalTriangleII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new LinkedList<>();
        result.add(1);

        if (rowIndex == 0) return result;

        result.add(1);

        if (rowIndex == 1) return result;

        for (int i = 1; i < rowIndex; i++) {

            int tmp = 1;
            int tmp1;
            int tmp2;

            for (int j = 1; j < result.size(); j++) {

                if (j == 1) {
                    tmp1 = result.get(j - 1);
                    tmp2 = result.get(j);
                    tmp = tmp1+tmp2;
                }else {

                    tmp1 = result.get(j-1);
                    tmp2 = result.get(j);
                    result.set(j-1, tmp);
                    tmp = tmp1+tmp2;

                }
            }
            result.set(result.size()-1, tmp);
            result.add(1);
        }


        return result;
    }


    @Test
    public void test(){

        List<Integer> result = getRow(4);

        List<Integer> base = new LinkedList<>();
        base.add(1);
        base.add(4);
        base.add(6);
        base.add(4);
        base.add(1);

        Assert.assertEquals(result, base);


    }

}
