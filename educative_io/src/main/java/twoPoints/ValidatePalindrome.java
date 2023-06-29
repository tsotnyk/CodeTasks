package twoPoints;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidatePalindrome {

    public boolean isPalindrome(String s){

        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return true;

        int left = 0;
        int right = s.length()-1;

        while (left < right){
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindrome("qwerewq"));
        Assert.assertFalse(isPalindrome("qwert"));
    }
}
