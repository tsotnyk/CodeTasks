package old.twoPoints;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        return isPalindrome(s, 0, s.length()-1, false);
    }

    public static boolean isPalindrome(String s, int left, int right, boolean flag){

        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                if (flag) return false;
                boolean validation = isPalindrome(s, left+1, right, true);
                if (validation) return true;
                return isPalindrome(s, left, right-1,true);
            }else {
                left++;
                right--;
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindrome("madame"));
    }
}
