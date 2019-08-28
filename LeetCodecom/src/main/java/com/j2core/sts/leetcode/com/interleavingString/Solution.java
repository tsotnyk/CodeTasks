package com.j2core.sts.leetcode.com.interleavingString;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length() != s1.length()+s2.length()) return false;

        int indexOne = s1.length()-1;
        int indexTwo = s2.length()-1;

        for (int i = s3.length()-1; i > -1; i--){

            char tmp = s3.charAt(i);
            if (indexOne > -1 && indexTwo > -1 && tmp == s1.charAt(indexOne) && tmp == s2.charAt(indexTwo)){
                if (isInterleave(s1.substring(0, indexOne), s2.substring(0, indexTwo+1), s3.substring(0, i))){
                    return true;
                }
                return isInterleave(s1.substring(0, indexOne + 1), s2.substring(0, indexTwo), s3.substring(0, i));

            }
            if (indexOne > -1 && s3.charAt(i) == s1.charAt(indexOne)){
                indexOne--;
            }else if (indexTwo > -1 && s3.charAt(i) == s2.charAt(indexTwo)){
                indexTwo--;
            }else {
                return false;
            }
        }

        return true;
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException("Input Invalid!");
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Set<String> set = new HashSet<>();

        return isInterleaveHelper(s1, s2, s3, 0, 0, 0, set);
    }

    private boolean isInterleaveHelper(String s1, String s2, String s3, int p1, int p2, int p3, Set<String> set) {
        if (p3 == s3.length()) {
            return true;
        }
        if (p1 == s1.length()) {
            return s2.substring(p2).equals(s3.substring(p3));
        }
        if (p2 == s2.length()) {
            return s1.substring(p1).equals(s3.substring(p3));
        }
        if (set.contains(p1 + "," + p2))  {
            return false;
        }

        if (s1.charAt(p1) == s3.charAt(p3)) {
            if (isInterleaveHelper(s1, s2, s3, p1 + 1, p2, p3 + 1, set)) {
                return true;
            }
        }

        if (s2.charAt(p2) == s3.charAt(p3)) {
            if (isInterleaveHelper(s1, s2, s3, p1, p2 + 1, p3 + 1, set)) {
                return true;
            }
        }

        set.add(p1 + "," + p2);
        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assert.assertFalse(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        Assert.assertTrue(isInterleave("aabc", "abad", "aabadabc"));

    }
}
