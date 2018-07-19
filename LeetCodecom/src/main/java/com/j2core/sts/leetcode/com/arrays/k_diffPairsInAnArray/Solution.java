package com.j2core.sts.leetcode.com.arrays.k_diffPairsInAnArray;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int findPairs(int[] nums, int k) {

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


    @Test
    public void test(){

        int result = findPairs(new int[]{1,2,3,4,5}, 1);

        System.out.print(result);

    }

}
