package com.j2core.sts.leetcode.com.arrays.findFirstAndLastPositionOfElementInSortedArray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1, -1};

        if (nums.length < 1) {
            return result;
        } else if (nums.length < 2) {
            if (nums[0] == target) {
                result[0] = 0;
                result[1] = 0;
                return result;
            } else return result;
        } else if (target < nums[0]) {
            return result;
        } else if (target > nums[nums.length - 1]) {
            return result;
        } else {
            int half = nums.length / 2;
            if (nums[half] == target) {
                result[0] = half;
                result[1] = half;
                int index = half - 1;
                while (index > -1) {
                    if (nums[index] == target) {
                        result[0] = index;
                        index--;
                    } else break;
                }
                index = half + 1;
                while (index < nums.length) {
                    if (nums[index] == target) {
                        result[1] = index;
                        index++;
                    } else break;
                }
            } else if (nums[half] < target) {
                for (int i = half + 1; i < nums.length; i++) {
                    if (nums[i] == target) {
                        result[0] = i;
                        result[1] = i;
                        i++;
                        while (i < nums.length && nums[i] == target) {
                            result[1] = i;
                            i++;
                        }
                        break;
                    } else if (nums[i] > target) {
                        break;
                    }
                }
            } else {
                for (int i = half - 1; i > -1; i--) {
                    if (nums[i] == target) {
                        result[0] = i;
                        result[1] = i;
                        i--;
                        while (i > -1 && nums[i] == target) {

                            result[0] = i;
                            i--;
                        }
                        break;
                    } else if (nums[i] < target) {
                        break;
                    }
                }
            }
        }
        return result;
    }


    @Test
    public void test(){

        int[] result = searchRange(new int[]{1,3}, 1);

        Assert.assertEquals(result, new int[]{3,4});

    }
}
