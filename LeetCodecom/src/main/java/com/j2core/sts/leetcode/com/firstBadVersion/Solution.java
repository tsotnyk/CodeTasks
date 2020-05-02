package com.j2core.sts.leetcode.com.firstBadVersion;

/*
         The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
*/

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int firstBadVersion(int n) {

        if (isBadVersion(1)) return 1;
        int start = 1;
        int end = n;
        int median;

        while (true){

            if (!isBadVersion(end-1)){
                return end;
            }else {
                median = (end-start)/2;
                if (isBadVersion(end-median)){
                    end = end-median;
                }else {
                    start = end-median;
                }
            }
        }
    }



    public int firstBadVersionOld(int n) {

        int start = 1;
        int stop = n;
        int median = n/2;
        int result = -1;
        while (result < 0){

            result = findBadVersionOld(start, stop, median);

            if (result == -1){
                stop = median;
            }else if (result == -2){
                start = median;
            }
            median = start + (stop-start)/2;
        }

        return result;
    }

    private int findBadVersionOld(int start, int stop, int median){

        int result = -2;
        if (isBadVersion(start)){
            result = start;
        }else if (!isBadVersion(stop-1)){
            result = stop;
        }else if (isBadVersion(median)){
            result = -1;
        }

        return result;
    }


    public boolean isBadVersion(int n){

        if (n < 4){
            return false;
        }else

        return true;
    }


    @Test
    public void test(){

        int result = firstBadVersion(5);

        Assert.assertTrue(result == 4);

    }
}
