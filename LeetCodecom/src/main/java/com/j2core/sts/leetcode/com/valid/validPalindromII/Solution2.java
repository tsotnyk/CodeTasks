package com.j2core.sts.leetcode.com.valid.validPalindromII;

public class Solution2 {

    public boolean validPalindrome(String s) {

        return isPalindrome(s, false);
    }

    private boolean isPalindrome(String s, boolean deleting){

        int i = 0;
        int j = s.length()-1;

        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                if (deleting) return false;
                boolean removeLeft = isPalindrome(s.substring(i+1, j+1), true);
                return removeLeft || isPalindrome(s.substring(i, j), true);
            }
            i++;
            j--;
        }

        return true;
    }
}
