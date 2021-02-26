package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FacebookOASolution1 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1){
            set.add(num);
        }

        HashSet<Integer> nextSet = new HashSet<>();

        for (int num : arr2){
            if (set.contains(num)){
                nextSet.add(num);
            }
        }

        set = nextSet;
        nextSet = new HashSet<>();

        for (int num : arr3){
            if (set.contains(num)){
                nextSet.add(num);
            }
        }

        TreeSet<Integer> treeSet = new TreeSet<>(nextSet);

        return new LinkedList<>(treeSet);
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length-1; i > -1; i--){
            int num = nums2[i];
            if (map.isEmpty()){
                map.put(num, -1);
            }else {
                int bigNum = num;
                for (int j = i+1; j < nums2.length; j++){
                    if (nums2[j] > bigNum){
                        bigNum = nums2[j];
                        break;
                    }
                }
                map.put(num, bigNum != num ? bigNum : -1);
            }
        }
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    @Test
    public void testNextGreaterElement(){

        Assert.assertArrayEquals(new int[]{-1,3,-1}, nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}));
    }
}
