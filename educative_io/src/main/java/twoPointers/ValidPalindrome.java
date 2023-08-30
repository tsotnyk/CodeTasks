package twoPointers;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) throws IllegalArgumentException{
        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return true;

        int left = 0;
        int right = s.length()-1;

        while (left < right){
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }

}
