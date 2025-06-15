package prepInterviewGoogle;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x%10 == 0) return false;

        int result = 0;
        int tmpX = x;

        while (tmpX > 0){
            if (result > 0) result *= 10;
            result += tmpX%10;
            tmpX = tmpX/10;
        }

        return result == x;
    }

}
