package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPalindromeIII {

    public boolean isValidPalindromeTLE(String s, int k) {

        if (s.length() < 2) return true;
        if (k >= s.length()-1) return true;
        int l = 0;
        int r = s.length()-1;

        while (l < r){

            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else {

                if (k == 0) return false;
                if (isValidPalindromeTLE(s.substring(l+1, r+1), k-1)){
                    return true;
                }
                return isValidPalindromeTLE(s.substring(l, r), k-1);
            }
        }

        return true;
    }

    public boolean isValidPalindrome(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) { dp[i][j] = dp[i + 1][j - 1] + 2; }
                else { dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); }
            }
        }
        return s.length() <= k + dp[0][s.length() - 1];
    }

    @Test
    public void test(){

        Assert.assertTrue(isValidPalindrome("abcdeca", 2));
        Assert.assertTrue(isValidPalindrome("abbababa", 1));
        Assert.assertFalse(isValidPalindrome("bacabaaa", 2));
    }
}
