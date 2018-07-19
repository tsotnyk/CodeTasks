package com.j2core.sts.codefights.com.codeInterview.autonomic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    //
    public int solution1(int A, int B) {
        // write your code in Java SE 8

        // we find an integer that raised to the power gives b or close to it
        int biggerNum = (int) Math.exp(Math.log(B)/2);

        // we find an integer that raised to the power gives A or close to it
        int smallerNum = (int) Math.exp(Math.log(A)/2);

        // if smallerNum is smaller A, our smaller num is smallerNum + 1;
        if (Math.pow(smallerNum, 2) < A){
            smallerNum++;
        }

        int count = 1;

        // count numbers witch raised to the power give sum between numbers A and B
        for (int i = smallerNum; i < biggerNum; i++){

            count++;

        }

        return count;

    }

    public boolean solution2(int[] A) {
        // write your code in Java SE 8

        if (A.length < 3) return true;

        int count = 0;
        int indexNum = 0;
        boolean clearFlag = true;
        for (int i = 1; i < A.length; i++){

            if (A[indexNum] < A[i] && clearFlag){

                indexNum++;

            }else if (A[indexNum] > A[i] && clearFlag){

                count++;
                clearFlag = false;

            }else if(A[indexNum] < A[i] && !clearFlag){

                indexNum = i;
                clearFlag = true;
            }else {
                boolean flag = true;
                for (int j = indexNum+1; j < i; j++) {

                        if (A[j] < A[i]) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        clearFlag = false;
                        count++;
                    }
            }
            if (count > 1) return false;

        }

        return true;
    }



    @Test
    public void test(){

//        int result = solution1(3, 17);
////
////        Assert.assertEquals(result, 3);

//        boolean result = solution(new int[]{1,3,5});
//        boolean result = solution(new int[]{1,5,3,3,7});
//
//        boolean result = solution(new int[]{1,3,5,3,4});
//
        boolean result = solution2(new int[]{1,5,3,3,7,6});

        Assert.assertTrue(result);

    }
}
