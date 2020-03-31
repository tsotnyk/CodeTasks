package com.j2core.sts.leetcode.com.arrays.findKSmallestPairDistance;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int length = nums.length;
        int left=0;
        int right=nums[length-1]-nums[0];
        int counter;
        int median;
        int i, j;
        while (left<right){
            median = (left+right)/2;
            counter = 0;
            for (i=0,j=0; i<length; i++){
                while (j<length && nums[j]<=nums[i]+median) j++;
                counter += j-i-1;
            }
            if (counter<k){
                left = median+1;
            }else{
                right = median;
            }
        }

        return left;
    }

    public int smallestDistancePairTimeLimit(int[] nums, int k) {

        int counter = 0;

        TreeSet<Integer> uniqDist = new TreeSet<>();
        HashMap<Integer, Integer> distances = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int dist = Math.abs(nums[i] - nums[j]);
                if (counter == k) {
                    int maxDist = uniqDist.last();
                    if (maxDist > dist) {
                        int maxDistValue = distances.get(maxDist);
                        if (maxDistValue > 1) {
                            distances.put(maxDist, maxDistValue - 1);
                        }else {
                            distances.remove(maxDist);
                            uniqDist.remove(maxDist);
                        }
                        counter--;
                    }
                }
                if (counter < k) {
                    if (distances.containsKey(dist)){
                        distances.put(dist, distances.get(dist)+1);
                    }else {
                        distances.put(dist, 1);
                    }
                    uniqDist.add(dist);
                    counter++;
                }
            }
        }

        int result = -1;

        for (int distance : uniqDist){
            k -= distances.get(distance);
            if (k <= 0){
                result = distance;
                break;
            }
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(smallestDistancePair(new int[]{1,3,1}, 1), 0);
        Assert.assertEquals(smallestDistancePair(new int[]{2,2,0,1,1,0,0,1,2,0}, 2), 0);
        Assert.assertEquals(smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8}, 18), 2);

    }
}
