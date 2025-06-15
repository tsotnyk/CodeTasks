package prepInterviewApple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while (left < right){
            char lch = s.charAt(left);
            if (!Character.isAlphabetic(lch) && !Character.isDigit(lch)){
                left++;
                continue;
            }
            char rch = s.charAt(right);
            if (!Character.isLetter(rch) && !Character.isDigit(rch)){
                right--;
                continue;
            }
            lch = Character.toLowerCase(lch);
            rch = Character.toLowerCase(rch);

            if (lch != rch) return false;
            left++;
            right--;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(isPalindrome("race a car"));
        Assert.assertTrue(isPalindrome(" "));
    }
}
