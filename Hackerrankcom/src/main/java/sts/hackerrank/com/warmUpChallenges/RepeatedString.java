package sts.hackerrank.com.warmUpChallenges;

import org.junit.Assert;
import org.junit.Test;

public class RepeatedString {

    public static long repeatedString(String s, long n) {
        // Write your code here

        if (s.length() == 1){
            return s.charAt(0) == 'a' ? n : 0;
        }

        int countOfA = 0;

        for (char symbol : s.toCharArray()){
            if (symbol == 'a') countOfA++;
        }

        if (countOfA == 0) return 0;

        long counter = (n/s.length())*countOfA;
        long delta = n%s.length();

        for (int i = 0; i < delta; i++){
            if (s.charAt(i) == 'a') counter++;
        }
        return counter;
    }

    @Test
    public void test(){
        Assert.assertEquals(7, repeatedString("aba", 10));
    }
}
