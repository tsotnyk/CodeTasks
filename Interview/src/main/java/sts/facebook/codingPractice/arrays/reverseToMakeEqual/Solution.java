package sts.facebook.codingPractice.arrays.reverseToMakeEqual;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution {

    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here

        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : array_a){
            if (numMap.containsKey(num)){
                numMap.put(num, numMap.get(num)+1);
            }else {
                numMap.put(num, 1);
            }
        }

        for (int num : array_b){
            if (numMap.getOrDefault(num, 0) == 0){
                return false;
            }else {
                numMap.put(num, numMap.get(num)-1);
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(areTheyEqual(new int[]{1,2,3,4}, new int[]{2,4,1,3}));
        Assert.assertTrue(areTheyEqual(new int[]{1,2,3,4}, new int[]{1,4,3,2}));
        Assert.assertTrue(areTheyEqual(new int[]{7}, new int[]{7}));
        Assert.assertTrue(areTheyEqual(new int[]{1,12}, new int[]{12,1}));
        Assert.assertTrue(areTheyEqual(new int[]{1,12}, new int[]{1,12}));
        Assert.assertTrue(areTheyEqual(new int[]{1,1,1,1,1}, new int[]{1,1,1,1,1}));
        Assert.assertFalse(areTheyEqual(new int[]{3,7,9}, new int[]{3,7,11}));
        Assert.assertFalse(areTheyEqual(new int[]{1,2,3,4}, new int[]{1,4,3,3}));
    }
}
