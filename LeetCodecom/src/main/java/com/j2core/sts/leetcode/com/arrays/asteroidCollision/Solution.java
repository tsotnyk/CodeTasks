package com.j2core.sts.leetcode.com.arrays.asteroidCollision;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        List<Integer> asteroidList = new ArrayList<>();

        for (Integer num : asteroids){

            asteroidList.add(num);

        }

        int baseIndex = 0;

        for (int i = 1; i < asteroidList.size(); ){

            int first = asteroidList.get(i-1);
            int second = asteroidList.get(i);

            if (first  > 0 && second < 0){

                if (Math.abs(first) == Math.abs(second)){
                    asteroidList.remove(i-1);
                    asteroidList.remove(i-1);
                }else {
                    if (Math.abs(first)  < Math.abs(second)){

                        asteroidList.remove(i-1);
                    }else {
                        asteroidList.remove(i);
                    }
                }
                i = baseIndex;
            }else if (first < 0){
                baseIndex++;
                i = baseIndex;
            }
            i++;
        }

        int[] result = new int[asteroidList.size()];

        for (int i = 0; i < asteroidList.size(); i++){
            result[i] = asteroidList.get(i);
        }

        return result;

    }


    @Test
    public void test(){

        int[] result = asteroidCollision(new int[]{-1, 5, 8, -8, -2, 10, 5, -5});

    }



}
