package com.j2core.sts.leetcode.com.arrays.maximumWidthRamp;

import java.util.Arrays;

public class Solution {

    public int maxWidthRamp1(int[] A) {

        int jIndex = A.length-1;
        int iIndex = jIndex-1;
        int maxLength = 0;

        while(jIndex > maxLength){

            int tmpIndex = -1;
            for(int i = iIndex; i > -1; i--){

                if(A[jIndex] >= A[i]){
                    tmpIndex = i;
                }
            }

            if(tmpIndex != -1){

                maxLength = Math.max(maxLength, jIndex-tmpIndex);
                if(iIndex-1 > -1){
                    iIndex--;
                }
            }

            jIndex--;
        }

        return maxLength;
    }

    public int maxWidthRamp2(int[] A) {

        int jIndex = A.length-1;
        int maxLength = 0;

        while(jIndex > maxLength){

            for(int i = 0; i <= jIndex; i++){

                if(i == jIndex){
                    jIndex--;
                }
                if(A[jIndex] >= A[i]){
                    maxLength = Math.max(maxLength, jIndex-i);
                }
            }

        }

        return maxLength;
    }

    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}
