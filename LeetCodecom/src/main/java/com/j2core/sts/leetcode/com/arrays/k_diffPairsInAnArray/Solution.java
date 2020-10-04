package com.j2core.sts.leetcode.com.arrays.k_diffPairsInAnArray;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {
    public int findPairsOld(int[] nums, int k) {

        if (k < 0) return 0;

        List<Pair> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 1; i++) {

            int tmp = nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                if (tmp + k == nums[j] || tmp - k == nums[j]) {

                    boolean flag = true;
                    Pair tmpPair = new Pair(nums[i], nums[j]);
                    for (Pair pair : result){
                        if (comparingPairs(pair, tmpPair)){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        result.add(tmpPair);
                    }
                }
            }
        }

        return result.size();

    }

    class Pair{

        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private boolean comparingPairs(Pair first, Pair second){

        return (first.i == second.i && first.j == second.j) || (first.i == second.j && first.j == second.i);

    }

    public int findPairs(int[] nums, int k) {

        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int j : nums) {
            numMap.put(j, numMap.getOrDefault(j, 0) + 1);
        }
        int counter = 0;

        for (int num : numMap.keySet()) {
            int nextNum = num + k;
            if (numMap.getOrDefault(nextNum, 0) > 0) {
                if (nextNum == num){
                    if (numMap.get(num) > 1){
                        counter++;
                    }
                }else {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Test
    public void test(){

//        int result = findPairs(new int[]{1,2,3,4,5}, 1);
//
//        System.out.print(result);

        Assert.assertEquals(findPairs(new int[]{3,1,4,1,5}, 2),2);
        Assert.assertEquals(findPairs(new int[]{1,2,3,4,5}, 1),4);
        Assert.assertEquals(findPairs(new int[]{1,3,1,5,4}, 0),1);
        Assert.assertEquals(findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3),2);
        Assert.assertEquals(findPairs(new int[]{-1,-2,-3}, 1),2);


    }

}
