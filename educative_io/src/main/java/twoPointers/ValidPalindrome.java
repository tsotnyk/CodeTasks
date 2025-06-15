package twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPalindrome {

    public static boolean isPalindromeOld(String s) throws IllegalArgumentException{
        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return true;

        int left = 0;
        int right = s.length()-1;

        while (left < right){
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }

    // Time complexity O(n), Space complexity O(1)
    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    @Test
    public void test_isPalindrome(){

        Assert.assertTrue(isPalindrome("kayak"));
        Assert.assertFalse(isPalindrome("hello"));
        Assert.assertFalse(isPalindrome("RACEACAR"));
        Assert.assertTrue(isPalindrome("A"));
        Assert.assertFalse(isPalindrome("ABCDABCD"));

    }
}
