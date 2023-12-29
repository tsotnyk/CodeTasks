package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseString {

    public void reverseString(char[] s) {

        int i = 0;
        int j = s.length-1;

        while (i < j){

            char tmp = s[j];
            s[j--] = s[i];
            s[i++] = tmp;

        }
    }

    @Test
    public void test(){

        char[] input = new char[]{'h', 'e', 'l', 'l', 'o' };
        reverseString(input);
        Assert.assertEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, input);
    }
}
