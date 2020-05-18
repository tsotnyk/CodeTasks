package com.j2core.sts.leetcode.com.missingRanges;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> findMissingRangesOld(int[] nums, int lower, int upper) {

        List<String> result = new LinkedList<>();

        if (nums.length == 0){
            if (lower == upper){
                result.add(String.valueOf(lower));
            }else {
                result.add((lower) + "->" + (upper));
            }
            return result;
        }

        long start = lower;
        int index = 0;
        long end;
        long tmp;

        while (index < nums.length){
            end = nums[index];
            tmp = end-start;
            if (index == 0){
                if (tmp == 1){
                    result.add(String.valueOf(start));
                }else if (tmp > 1){
                    result.add((start) + "->" + (end-1));
                }
            }else if (tmp == 2){
                result.add(String.valueOf(start+1));
            }else if (tmp > 2){
                result.add((start+1) + "->" + (end-1));
            }
            start = end;
            index++;
        }

        tmp = upper - start;
        if (tmp == 1){
            result.add(String.valueOf(upper));
        }else if (tmp > 1){
            result.add((start+1) + "->" + (upper));
        }

        return result;
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        long first = lower;
        long last = upper;
        List<String> result = new LinkedList<>();
        String interval;

        if (lower == upper && nums.length == 0){
            result.add(String.valueOf(first));
            return result;
        }

        for (int num : nums){

            if (num == first){
                first++;
                if (first > last) break;
            }else if (num == last){
                last--;
                break;
            }else if (num > first && num < last){
                interval = createInterval(first, num, false);
                if (interval != null){
                    result.add(interval);
                }
                first = num+1;
            }
        }

        interval = createInterval(first, last, true);
        if (interval != null){
            result.add(interval);
        }

        return result;

    }

    private String createInterval(long first, long num, boolean lastInterval){

        if (first > num) return null;
        if (first == num) return String.valueOf(first);
        if (lastInterval){
            return first+"->"+num;
        }else {
            if (first+1 == num){
                return String.valueOf(first);
            }
            return first+"->"+(num-1);
        }
    }

    public List<String> findMissingRangesNew(int[] nums, int lower, int upper) {
        //keep a list to store the result
        List <String> res = new ArrayList<>();

        //keep track of the next number you should see
        long next = lower;
        for (int i = 0 ; i < nums.length; i ++){
            //check if the current number, is the one you were expecting
            if (nums[i]!=next){
                //if the current number is less than lower bound, just ignore it
                if(nums[i]<lower) continue;
                //if the current number is greater than the upper, then lock it to the upper
                //find the range to be added and break the loop (the remaining numbers are not in the bound)
                if (nums[i]>upper){
                    addRange(res, next, upper+1);
                    break;
                }
                addRange(res, next, nums[i]);
            }
            next = (long)nums[i]+1;
        }

        //add the remaining range
        addRange(res, next, (long)upper+1);
        return res;
    }

    private void addRange(List<String> ranges, long start, long end){
        if (end-start ==1){
            ranges.add(String.valueOf(start));
        }else if (end-start >1){
            ranges.add(start+"->"+(end-1));
        }
    }

    @Test
    public void test(){

        List<String> result1 = findMissingRanges(new int[]{}, 1, 1);

        List<String> result = findMissingRanges(new int[]{-2147483648,2147483647}, -2147483648, 2147483647);
    }
}
