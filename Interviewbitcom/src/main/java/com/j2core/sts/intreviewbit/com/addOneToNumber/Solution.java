package com.j2core.sts.intreviewbit.com.addOneToNumber;

public class Solution {

    public int[] plusOne(int[] A) {

        if (A.length < 1) return new int[]{1};

        int tmpNum;
        int delta = 1;
        for (int i = A.length-1; i > -1; i--){

            tmpNum = A[i]+delta;

            if (tmpNum > 9){
                A[i] = 0;
                delta = 1;
            }else {
                A[i] = tmpNum;
                delta = 0;
            }
        }

        if (delta != 0){
            int[] result = new int[A.length+1];
            result[0] = delta;
            System.arraycopy(A, 0, result, 1, A.length);
            return result;
        }else {
            int index = -1;
            for (int i = 0; i < A.length; i++){
                if (A[i] == 0){
                    index = i;
                }else {
                    break;
                }
            }
            if (index != -1){
                int[] result = new int[A.length-index-1];
                System.arraycopy(A, index+1, result, 0, A.length-index-1);
                return result;
            }else return A;
        }
    }

}
