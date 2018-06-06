package com.j2core.sts.codefights.com.dataStructures.arrays.firstDuplicate;

public class Solution {

    public int firstDuplicate(int[] a){

        if (a.length < 2) return -1;
        if (a.length == 2){
            return   (a[0] == a[1]) ? a[0] : -1;
        }else {

            for (int i = 1; i < a.length; i++){

                int tmpNum = a[i];
                for (int j = 0; j < i; j++){

                    if (a[j] == tmpNum){
                        return tmpNum;
                    }
                }
            }
        }

        return -1;
    }
}
