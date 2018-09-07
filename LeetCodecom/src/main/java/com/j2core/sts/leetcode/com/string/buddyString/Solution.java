package com.j2core.sts.leetcode.com.string.buddyString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) return false;

        if (A.length() < 2){

            return false;

        }else if (A.length() == 2){

            return A.charAt(0) == B.charAt(1) && A.charAt(1) == B.charAt(0);

        }else {

            List<Integer> indexes = new LinkedList<>();

            for (int i = 0; i < A.length(); i++){

                if (A.charAt(i) != B.charAt(i)){

                    indexes.add(i);
                    if (indexes.size() > 2) return false;

                }else {

                    if ( i > 0){

                        char tmp = A.charAt(i);

                        for (int j = 0; j < i; j++){

                            if (tmp == A.charAt(j)) return true;

                        }
                    }
                }
            }

            if (indexes.size() == 2) {

                return A.charAt(indexes.get(0)) == B.charAt(indexes.get(1)) && A.charAt(indexes.get(1)) == B.charAt(indexes.get(0));

            }else return false;
        }
    }


    @Test
    public void test(){

        Assert.assertTrue(buddyStrings("abc", "acb"));

        Assert.assertTrue(buddyStrings("aa", "aa"));

        Assert.assertTrue(buddyStrings("ab", "ba"));

        Assert.assertFalse(buddyStrings("", "aaaaacb"));

        Assert.assertFalse(buddyStrings("ab", "ab"));

        Assert.assertFalse(buddyStrings("abcd", "acdb"));

        Assert.assertFalse(buddyStrings("abcd", "abcd"));


    }



}
