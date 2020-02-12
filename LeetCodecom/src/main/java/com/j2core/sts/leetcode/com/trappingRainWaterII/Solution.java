package com.j2core.sts.leetcode.com.trappingRainWaterII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int trapRainWater(int[][] heightMap) {

        if (heightMap.length < 3 || heightMap[0].length < 3) return 0;

        int sum = 0;
        int[][] tmpWaterCounter = trapHorizontal(heightMap);

        trapVertical(heightMap, tmpWaterCounter);

        for (int i = 1; i < tmpWaterCounter.length-1; i++){
            for (int j = 1; j < tmpWaterCounter[0].length-1; j++){
                int tmp = tmpWaterCounter[i][j];
                int vert = tmpWaterCounter[tmpWaterCounter.length-1][j];
                int goriz = tmpWaterCounter[i][tmpWaterCounter[0].length-1];
                if ( tmp != -1 && vert != 0 && goriz != 0){
                    int min = Integer.min(tmpWaterCounter[tmpWaterCounter.length-1][j], tmpWaterCounter[i][tmpWaterCounter[0].length-1]);
                    if (tmpWaterCounter[i][j] < min) {
                        sum += min - tmpWaterCounter[i][j];
                    }
                }
            }
        }

        return sum;
    }

    private void trapVertical(int[][] heightMap, int[][] tmpWaterCounter){

        for (int j = 1; j < heightMap[0].length; j++){
            int indexEnd = heightMap.length-1;
            int indexStart = indexEnd-1;

            while (indexEnd > 0){

                if (heightMap[indexStart][j] < heightMap[indexEnd][j]){
                    while (indexStart > -1 && heightMap[indexStart][j] < heightMap[indexEnd][j]){
                        indexStart--;
                    }
                    if (indexStart > -1){
                        int minH = Integer.min(heightMap[indexStart][j], heightMap[indexEnd][j]);
                        for (int i = indexStart+1; i < indexEnd; i++){
                            if (tmpWaterCounter[i][tmpWaterCounter[0].length-1] == 0) {
                                tmpWaterCounter[i][tmpWaterCounter[0].length - 1] = minH;
                            }else {
                                tmpWaterCounter[i][tmpWaterCounter[0].length-1] = Integer.min(tmpWaterCounter[i][tmpWaterCounter[0].length-1], minH);
                            }
                        }
                        indexEnd = indexStart--;
                    }else {
                        heightMap[indexEnd][j] = heightMap[indexEnd][j] -1;
                        indexStart = indexEnd-1;
                    }
                }else {
                    indexEnd = indexStart--;
                }
            }
        }
    }

    private int[][] trapHorizontal(int[][] height) {

        int[][] result = creteMatrix(height.length+1, height[0].length+1);
        int delta = 0;
        for (int i = 1; i < height.length-1; i++){

            int[] line = height[i];
            int indexEnd = line.length-1;
            int indexStart = indexEnd-1;

            while (indexEnd > 1){

                if (line[indexStart] < line[indexEnd]+delta){
                    while (indexStart > -1 && line[indexStart] < line[indexEnd]+delta){
                        indexStart--;
                    }
                    if (indexStart > -1){
                        int minH = Integer.min(line[indexStart], line[indexEnd]+delta);
                        for (int j = indexStart+1; j < indexEnd; j++){
                            result[i][j] = line[j];
                            if (result[height.length][j] == 0) {
                                result[height.length][j] = minH;
                            }else {
                                int min = Integer.min(result[height.length][j], minH);
                                if (result[height.length][j] == 0) {
                                    result[height.length][j] = min;
                                }else {
                                    result[height.length][j] = Integer.min(min, result[height.length][j]);
                                }
                            }
                        }
                        indexEnd = indexStart--;
                        delta = 0;
                    }else {
                        delta--;
                        indexStart = indexEnd-1;
                    }
                }else {
                    indexEnd = indexStart--;
                }
            }
        }
        return result;
    }

    private int[][] creteMatrix(int i, int j){

        int[][] result = new int[i][j];
        for (int k = 0; k < i-1; k++){
            for (int l = 0; l < j-1; l++){
                result[k][l] = -1;
            }
        }
        return result;
    }

    @Test
    public void test(){

        int result  = trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}});
        Assert.assertEquals(result, 4);
        int result1  = trapRainWater(new int[][]{{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}});
        Assert.assertEquals(result1, 14);
        int result2  = trapRainWater(new int[][]{{5,5,5,1},{5,1,1,5},{5,1,5,5},{5,2,5,8}});
        Assert.assertEquals(result2, 3);
        int result3  = trapRainWater(new int[][]{{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}});
        Assert.assertEquals(result3, 215);
        int result4  = trapRainWater(new int[][]{{5,8,7,7},{5,2,1,5},{7,1,7,1},{8,9,6,9},{9,8,9,9}});
        Assert.assertEquals(result4, 12);
    }
}
