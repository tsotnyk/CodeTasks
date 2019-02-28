package com.j2core.sts.leetcode.com.primePalindrome;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int primePalindrome(int N) {
        if (N == 1 || N == 2) return 2;
        if (N % 2 == 0) N++;
        while (true) {
            if (isPalindrome(N) && isPrime(N)) return N;
            N += 2;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_001;
        }
    }


    private boolean isPrime(int num){
        int end = (int)Math.sqrt(num);
        for (int i = 3; i <= end; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private boolean isPalindrome(Integer num){

        String string = num.toString();

        int indexStart = 0;
        int indexEnd = string.length()-1;

        while (indexStart < indexEnd){

            if (string.charAt(indexStart++) != string.charAt(indexEnd--)){
                return false;
            }

        }
        return true;
    }


    @Test
    public void test(){

        int result = primePalindrome(102);

        Assert.assertEquals(result, 131);

    }

}
