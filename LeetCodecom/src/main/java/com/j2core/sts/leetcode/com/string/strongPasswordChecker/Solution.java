package com.j2core.sts.leetcode.com.string.strongPasswordChecker;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int strongPasswordChecker(String s) {

        int one = 0, two = 0, chg = 0, p = 0, l = s.length(), r = 0, up = 0, lo = 0, d = 0;
        while (p < l) {
            char c = s.charAt(p);
            if (Character.isUpperCase(c)) up = 1;
            if (Character.isLowerCase(c)) lo = 1;
            if (Character.isDigit(c)) d = 1;
            if (p > 1 && c == s.charAt(p - 1) && c == s.charAt(p - 2)) {
                r = 2;
                while (p < l && s.charAt(p) == c) {
                    p++;
                    r++;
                }
                if (r % 3 == 0) one++;
                else if (r % 3 == 1) two++;
                chg += r / 3;
            } else p++;
        }
        int miss = 3 - up - lo - d;
        if (l < 6) {
            return Math.max(miss, 6 - l);
        } else if (l <= 20) {
            return Math.max(miss, chg);
        } else {
            int del = l - 20;
            chg -= Math.min(del, one);
            chg -= Math.min(Math.max(del - one, 0), two * 2) / 2;
            chg -= Math.max(del - one - 2 * two, 0) / 3;
            return del + Math.max(chg, miss);
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(strongPasswordChecker("11x11Z11z1111"), 0);
    }
}
