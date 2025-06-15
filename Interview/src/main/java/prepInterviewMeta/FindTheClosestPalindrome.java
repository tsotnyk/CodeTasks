package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTheClosestPalindrome {

    public String nearestPalindromic(String n) {

        if(n.length() < 2) return String.valueOf((char) (n.charAt(0)-1));
        char[] right = n.toCharArray();
        char[] left = n.toCharArray();

        do {

            left = decreaseNumber(left, left.length-1);
            if (isPalindrome(left)) return String.valueOf(left);
            right = increaseNumber(right, right.length-1);
        } while (!isPalindrome(right));

        return String.valueOf(right);
    }

    public char[] increaseNumber(char[] number, int index){

        if (index == 0 && number[index] == '9'){

            number[index] = '0';
             char[] newNum = new char[number.length+1];
             System.arraycopy(number, 0, newNum, 1, number.length);
             newNum[0] = '1';
             return newNum;
        }

        if (number[index] != '9') {
            number[index] = (char)(number[index]+1);
            return number;
        }

        number[index] = '0';
        return increaseNumber(number, index-1);

    }

    public char[] decreaseNumber(char[] number, int index){

        if (index == 0 && number[index] == '1'){
            char[] newNum = new char[number.length-1];
            System.arraycopy(number, 1, newNum, 0, number.length-1);
            return newNum;
        }

        if (number[index] > '0'){
            number[index] = (char)(number[index]-1);
            return number;
        }

        number[index] = '9';
        return decreaseNumber(number, index-1);
    }

    public boolean isPalindrome(char[] number){

        int l = 0;
        int r = number.length-1;

        while (l < r){
            if (number[l++] != number[r--]) return false;
        }
        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(nearestPalindromic("99"), "101");


        char[] test = increaseNumber(new char[]{'9', '9'}, 1);
        char[] test2 = increaseNumber(new char[]{'9', '5'}, 1);
        char[] test3 = decreaseNumber(new char[]{'9', '0'}, 1);
        char[] test4 = decreaseNumber(new char[]{'1', '0'}, 1);

        Assert.assertEquals(nearestPalindromic("1"), "0");
        Assert.assertEquals(nearestPalindromic("5"), "4");
        Assert.assertEquals(nearestPalindromic("9"), "8");

        Assert.assertEquals(nearestPalindromic("123"), "121");
    }
}
