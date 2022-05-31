package com.j2core.sts.hackerrank.com.bigsorting;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        String[] sorted = unsorted;
        Arrays.sort(sorted, (t1, t2) ->{
            if (t1.length() != t2.length()){
                return t1.length() - t2.length();
            }
            return t1.compareTo(t2);
        });

        return sorted;
    }

    @Test
    public void test(){

        Assert.assertEquals(bigSorting(new String[]{"303", "333", "23","0","1","12345", "23"}), new String[]{"0", "1","23","23","303","333","12345"});
    }
}
