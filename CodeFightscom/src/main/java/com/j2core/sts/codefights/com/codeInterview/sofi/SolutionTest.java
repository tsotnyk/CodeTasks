package com.j2core.sts.codefights.com.codeInterview.sofi;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SolutionTest {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int result = 1;
        int[] sorted = IntStream.of(A)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        for(int i = sorted.length-1; i > -1; i--){

            if (sorted[i] > 0) {
                if (sorted[i] > result + 1) {
                    result = result + 1;
                    break;
                } else {
                    result = sorted[i];
                }
            }

        }

        if (result == sorted[0]){
            result = result+1;
        }
        return result;
    }


    @Test
    public void test1(){

        int result = solution(new int[]{1,3,6,4,1,2});

        Assert.assertEquals(5, result);

        int result1 = solution(new int[]{1,2,3});

        Assert.assertEquals(4, result1);

        int result2 = solution(new int[]{-2, -1});

        Assert.assertEquals(1, result2);
    }
}
