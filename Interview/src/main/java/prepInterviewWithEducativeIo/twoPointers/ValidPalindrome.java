package prepInterviewWithEducativeIo.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if (s == null) return false;
        if (s.length() < 2) return true;

        String loverCaseString = s.toLowerCase();
        int l = 0;
        int r = loverCaseString.length()-1;

        while (l < r){
            if (!Character.isLetter(loverCaseString.charAt(l))){
                l++;
                continue;
            }
            if (!Character.isLetter(loverCaseString.charAt(r))){
                r--;
                continue;
            }
            if (loverCaseString.charAt(l) != loverCaseString.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindrome("kaYak"));
    }
}
