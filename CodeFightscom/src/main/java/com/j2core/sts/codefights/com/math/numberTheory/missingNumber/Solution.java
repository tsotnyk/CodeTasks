package com.j2core.sts.codefights.com.math.numberTheory.missingNumber;

import java.util.Arrays;

public class Solution {

    int missingNumber(int[] arr) {

        if (arr.length < 1){
            return 0;
        }else if (arr.length < 2){
            return arr[0] == 0 ? 1 : 0;
        }else {

            Arrays.sort(arr);

            int expectNum = 0;

            for (int num : arr){

                if (num != expectNum){

                    return expectNum;

                }else {

                    expectNum++;

                }
            }

            return expectNum;
        }
    }
}
