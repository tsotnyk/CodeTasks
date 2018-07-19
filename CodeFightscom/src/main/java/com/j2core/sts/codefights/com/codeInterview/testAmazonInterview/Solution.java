package com.j2core.sts.codefights.com.codeInterview.testAmazonInterview;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> cellCompete (int[] sat, int days){

        for(int i = 0; i < days; i++){

            int[] tmpStatus = new int[sat.length];

            for (int j = 0; j < sat.length; j ++){

                if (j == 0){

                    if (sat[j+1] != 0){

                        tmpStatus[j] = 1;
                    }
                }else if (j < sat.length-1){

                    if (sat[j-1] != sat[j+1]){
                        tmpStatus[j] = 1;
                    }
                } else {

                    if (sat[j-1] != 0){

                        tmpStatus[j] = 1;
                    }
                }
            }
            sat = tmpStatus;
        }

        List<Integer> result = new LinkedList<>();

        for (int num: sat){

            result.add(num);

        }
        return result;
    }


    public int generalizedGCD(int num, int[] arr){


        int result = 1;
        int small = arr[0];

        for (int i = 1; i< arr.length; i++){

            if (arr[i] < small){

                small = arr[i];
            }

        }

        if (small > result){

            for (int j = small; j > result; j--){

                int tmp = j;

                for (int jh : arr){

                    if (jh%j != 0){

                        tmp = result;
                        break;
                    }
                }
                if (tmp > result){
                    result = tmp;
                }
            }
        }

        return result;
    }



    @Test
    public void test(){


        int result = generalizedGCD(5, new int[]{2,4,6,8,10});

        Assert.assertEquals(result, 5);

        //        List<Integer> result = cellCompete(new int[]{1,1,1,0,1,1,1,1}, 2);
//
//        Assert.assertEquals(result, new LinkedList<Integer>());

    }
}
