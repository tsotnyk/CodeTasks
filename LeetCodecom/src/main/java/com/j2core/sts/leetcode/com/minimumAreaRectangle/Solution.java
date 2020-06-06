package com.j2core.sts.leetcode.com.minimumAreaRectangle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int minAreaRect(int[][] points) {

        if (points.length < 4) return 0;

        int minArea = Integer.MAX_VALUE;

        ArrayList<Integer> xUniqIndex = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> pointsMap = new HashMap<>();

        for (int[] point : points){
            int x = point[0];
            if (pointsMap.containsKey(x)){
                pointsMap.get(x).add(point[1]);
            }else {
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(point[1]));
                pointsMap.put(x, list);
                xUniqIndex.add(x);
            }
        }

        for (int i = 0; i < xUniqIndex.size()-1; i++){
            for (int j = i+1; j < xUniqIndex.size(); j++){
                minArea = Math.min(countArea(xUniqIndex.get(i), xUniqIndex.get(j), pointsMap), minArea);
            }
        }

        return minArea != Integer.MAX_VALUE ?  minArea : 0;
    }

    private int countArea(Integer x1, Integer x2, HashMap<Integer, ArrayList<Integer>> pointsMap) {

        int area = Integer.MAX_VALUE;
        ArrayList<Integer> y1 = new ArrayList<>(pointsMap.get(x1));
        ArrayList<Integer> y2 = pointsMap.get(x2);

        if (y1.size() < 2 || y2.size() < 2) return area;

        y1.retainAll(y2);

        if(y1.size() < 2) return area;

        int xDelta = Math.abs(x1 - x2);
        int tmpArea;

        for(int i = 0; i < y1.size()-1; i++){
            for (int j = i+1; j < y1.size(); j++){
                tmpArea = Math.abs(y1.get(i)-y1.get(j)) * xDelta;
                area = Math.min(area, tmpArea);
            }
        }

        return  area;
    }

    @Test
    public void test(){

        Assert.assertEquals(minAreaRect(new int[][]{{3,2},{0,0},{3,3},{3,4},{4,4},{2,1},{4,3},{1,0},{4,1},{0,2}}), 1);

        Assert.assertEquals(minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}}), 4);
        Assert.assertEquals(minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}}), 2);

    }

}
