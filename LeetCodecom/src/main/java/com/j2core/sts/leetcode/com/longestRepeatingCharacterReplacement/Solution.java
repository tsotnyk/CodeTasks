package com.j2core.sts.leetcode.com.longestRepeatingCharacterReplacement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int characterReplacement(String s, int k) {

        int length = s.length();
        if (length <= k){
            return length;
        }

        int result = k;
        for (int i = 0; i < length-k; i++){
            int changes = k;
            char baseChar = s.charAt(i);
            int index = i+1;
            int counter = 1;
            while (index < length && (s.charAt(index) == baseChar || changes > 0)){
                counter++;
                if(s.charAt(index) != baseChar){
                    changes--;
                }
                index++;
            }

            counter = counter + changes > length ? length : counter+changes;

            if (result < counter){
                result = counter;
            }
        }
        return result;
    }

    @Test
    public void test(){

        int result = characterReplacement("ABBB", 2);

        Assert.assertEquals( result, 4);

    }
}
