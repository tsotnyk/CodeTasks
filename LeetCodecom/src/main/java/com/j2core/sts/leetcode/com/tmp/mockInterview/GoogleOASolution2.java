package com.j2core.sts.leetcode.com.tmp.mockInterview;

import java.util.ArrayList;
import java.util.List;

public class GoogleOASolution2 {

    public int findPeakElement(int[] nums) {

        for (int i = 1; i < nums.length-1; i++){
            if (nums[i-1] < nums[i] && nums[i+1] < nums[i]) return i;
        }

        return nums[0] > nums[nums.length-1] ? 0 : nums.length-1;
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n < 2) return false;
        if (n == 2) return s.charAt(0) == s.charAt(1);

        for (int i = (int)Math.sqrt(n); i > 0; i--) {
            if (n % i == 0) {
                List<Integer> divisors = new ArrayList<>();
                divisors.add(i);
                if (i != 1) {
                    divisors.add(n / i);
                }
                for (int l : divisors) {
                    String tmp = s.substring(0, l);
                    int firstHash = tmp.hashCode();
                    int currHash = firstHash;
                    int start = l;
                    while (start != n && currHash == firstHash) {
                        tmp = s.substring(start, start + l);
                        currHash = tmp.hashCode();
                        start += l;
                    }
                    if (start == n && currHash == firstHash) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
