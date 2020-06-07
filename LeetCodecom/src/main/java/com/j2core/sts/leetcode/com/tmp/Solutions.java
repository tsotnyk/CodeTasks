package com.j2core.sts.leetcode.com.tmp;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solutions {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (t1, t2) -> t1[0] == t2[0] ? t1[1] - t2[1] : t2[0] - t1[0]);

        ArrayList<int[]> output = new ArrayList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        return output.toArray(new int[people.length][2]);

    }

    @Test
    public void test(){

        int[][] result = reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        Assert.assertEquals(result.length, 6);
    }

}

