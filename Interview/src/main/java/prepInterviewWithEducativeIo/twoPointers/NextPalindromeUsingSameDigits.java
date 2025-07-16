package prepInterviewWithEducativeIo.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPalindromeUsingSameDigits {

    public static String findNextPalindromeWrong(String numStr) {

        if (numStr == null || numStr.length() < 2) return "";

        char[] arr = numStr.toCharArray();

        int left = numStr.length()/2-1;
        int right = numStr.length()%2 == 0 ? left+1 : left+2;

        while (left > 0){
            if (arr[left -1] >= arr[left]){
                left--;
                right++;
            }else {
                char tmp = arr[left];
                arr[left] = arr[left-1];
                arr[left-1] = tmp;
                tmp = arr[right];
                arr[right] = arr[right+1];
                arr[right+1] = tmp;
                return String.valueOf(arr);
            }
        }
        return "";
    }


    public boolean findNextPermutation(List<Character> digits) {
        int i = digits.size() - 2;
        while (i >= 0 && digits.get(i) >= digits.get(i + 1)) {
            i--;
        }
        if (i == -1) {
            return false;
        }

        int j = digits.size() - 1;
        while (digits.get(j) <= digits.get(i)) {
            j--;
        }

        Collections.swap(digits, i, j);
        Collections.reverse(digits.subList(i + 1, digits.size()));
        return true;
    }

    public String findNextPalindromeBase(String numStr) {
        int n = numStr.length();

        if (n == 1) {
            return "";
        }

        int halfLength = n / 2;
        List<Character> leftHalf = new ArrayList<>();
        for (int i = 0; i < halfLength; i++) {
            leftHalf.add(numStr.charAt(i));
        }

        if (!findNextPermutation(leftHalf)) {
            return "";
        }

        StringBuilder nextPalindrome = new StringBuilder();
        for (char c : leftHalf) {
            nextPalindrome.append(c);
        }

        if (n % 2 == 0) {
            nextPalindrome.append(new StringBuilder(nextPalindrome).reverse());
        } else {
            nextPalindrome.append(numStr.charAt(halfLength));
            nextPalindrome.append(new StringBuilder(nextPalindrome.substring(0, halfLength)).reverse());
        }

        if (nextPalindrome.toString().compareTo(numStr) > 0) {
            return nextPalindrome.toString();
        }
        return "";
    }

    @Test
    public void test(){

        Assert.assertEquals(findNextPalindromeBase("45544554"), "54455445");
        Assert.assertEquals(findNextPalindromeBase("12321"), "21312");
        Assert.assertEquals(findNextPalindromeBase("5"), "");
        Assert.assertEquals(findNextPalindromeBase("1234321"), "1324231");
        Assert.assertEquals(findNextPalindromeBase("123321"), "132231");

    }
}
