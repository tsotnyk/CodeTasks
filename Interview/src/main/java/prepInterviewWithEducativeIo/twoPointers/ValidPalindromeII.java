package prepInterviewWithEducativeIo.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPalindromeII {

    public boolean isPalindrome(String string) {

        return isPalindrome(string, false);
    }

    public static boolean isPalindrome(String string, boolean flag){

        int left = 0;
        int right = string.length()-1;
        while (left < right){
            if (string.charAt(left)!= string.charAt(right)){
                if (flag) return false;
                if(isPalindrome(string.substring(left, right), true)) return true;
                return isPalindrome(string.substring(left+1, right+1), true);
            }
            left++;
            right--;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindrome("madame"));

        Assert.assertTrue(isPalindrome("RACEACAR"));
        Assert.assertTrue(isPalindrome("abbababa"));
        Assert.assertFalse(isPalindrome("abcdeca"));
    }
}
