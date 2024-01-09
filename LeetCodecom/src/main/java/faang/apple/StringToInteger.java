package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringToInteger {

    public int myAtoi(String s) {

        long num = 0;
        boolean negative = false;
        int index = 0;

        while (index < s.length() && s.charAt(index) == ' '){
            index++;
        }

        if (index >= s.length()) return 0;

        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            if (s.charAt(index++) == '-') negative = true;
        }

        while (index < s.length()){

            char sym = s.charAt(index++);
            if (!Character.isDigit(sym)) break;
            int candidate = (int)sym - '0';
            if ((num*10)+candidate > Integer.MAX_VALUE){
                num = negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                negative = false;
                break;
            }
            num = (num*10)+candidate;
        }

        return negative ? (int)num*-1 : (int)num;
    }

@Test
    public void test(){

    Assert.assertEquals(2147483647, myAtoi("21474836460"));
    Assert.assertEquals(-42, myAtoi("    -42"));
    Assert.assertEquals(42, myAtoi("42   "));
    Assert.assertEquals(4193, myAtoi("4193 with words"));
}
}
