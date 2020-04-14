package com.j2core.sts.leetcode.com.findClosestPalindrome;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public String nearestPalindromic(String n) {
        long val = Long.parseLong(n);
        long hi = high(val + 1);
        long lo = low(val - 1);
        return String.valueOf((Math.abs(val - hi) < Math.abs(val - lo)) ? hi : lo);
    }

    private long high(long val) {
        char[] s = String.valueOf(val).toCharArray();
        int l = s.length;
        char[] t = Arrays.copyOf(s, l);
        for (int i = 0; i < l/2; i++) {
            t[l - i - 1] = t[i];
        }
        for (int i = 0; i < l; i++){
            if (s[i] < t[i]) {
                return Long.parseLong(String.valueOf(t));
            } else if (s[i] > t[i]) {
                int j = (l - 1) / 2;
                while (j >= 0) {
                    if (++t[j] > '9'){
                        t[j--] = '0';
                    } else {
                        break;
                    }
                }
                for (j = 0; j < l/2; j++) {
                    t[l - j - 1] = t[j];
                }
                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    private long low(long val) {
        char[] s = String.valueOf(val).toCharArray();
        int l = s.length;
        char[] t = Arrays.copyOf(s, l);
        for (int i = 0; i < l/2; i++) {
            t[l - i - 1] = t[i];
        }
        for (int i = 0; i < l; i++){
            if (s[i] > t[i]) {
                return Long.parseLong(String.valueOf(t));
            } else if (s[i] < t[i]) {
                int j = (l - 1) / 2;
                while (j >= 0) {
                    if (--t[j] < '0'){
                        t[j--] = '9';
                    } else {
                        break;
                    }
                }
                if (t[0] == '0') {
                    char[] a = new char[l - 1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a));
                }
                for (j = 0; j < l/2; j++) {
                    t[l - j - 1] = t[j];
                }
                long res = Long.parseLong(String.valueOf(t));
                System.out.println(res);
                return res;
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    @Test
    public void test(){

        Assert.assertEquals(nearestPalindromic("1"), "0");
        Assert.assertEquals(nearestPalindromic("10"), "9");
        Assert.assertEquals(nearestPalindromic("11"), "9");
        Assert.assertEquals(nearestPalindromic("123"), "121");
        Assert.assertEquals(nearestPalindromic("1001"), "999");
        Assert.assertEquals(nearestPalindromic("1221"), "1111");
        Assert.assertEquals(nearestPalindromic("10101"), "10001");
        Assert.assertEquals(nearestPalindromic("99"), "101");

    }
}
