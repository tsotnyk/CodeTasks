package com.j2core.sts.leetcode.com.matrix.floodFill;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int iLength = image.length;
        int jLength = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor == newColor) return image;

        Queue<int[]> pairList = new LinkedList<>();
        pairList.add(new int[]{sr, sc});

        while (!pairList.isEmpty()){
            int[] coordinate = pairList.poll();
            if (coordinate[0] > 0 && image[coordinate[0]-1][coordinate[1]] == oldColor){
                pairList.add(new int[]{coordinate[0]-1, coordinate[1]});
            }
            if (coordinate[0]+1 < iLength && image[coordinate[0]+1][coordinate[1]] == oldColor){
                pairList.add(new int[]{coordinate[0]+1, coordinate[1]});
            }
            if (coordinate[1] > 0 && image[coordinate[0]][coordinate[1]-1] == oldColor){
                pairList.add(new int[]{coordinate[0], coordinate[1]-1});
            }
            if (coordinate[1]+1 < jLength && image[coordinate[0]][coordinate[1]+1] == oldColor){
                pairList.add(new int[]{coordinate[0], coordinate[1]+1});
            }
            image[coordinate[0]][coordinate[1]] = newColor;
        }

        return image;
    }

    @Test
    public void test(){

//        int[][] result = floodFill(new int[][]{{1,1,1}, {1,1,0}, {1,0,1}}, 1, 1, 2);

        int[][] result2 = floodFill(new int[][]{{0,0,0}, {0,0,1}}, 1, 1, 1);


        Assert.assertNotNull(result2);

    }
}
