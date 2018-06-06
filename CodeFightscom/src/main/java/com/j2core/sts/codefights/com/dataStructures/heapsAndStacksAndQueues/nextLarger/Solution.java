package com.j2core.sts.codefights.com.dataStructures.heapsAndStacksAndQueues.nextLarger;

public class Solution {

    int[] nextLarger(int[] a) {

        int length = a.length;
        if (length < 1){
            return a;
        }else if (length < 2){
            return new int[]{-1};
        }else {

            int[] result = new int[length];
            result[length-1] = -1;
            for (int i = length-2; i > -1; i--){

                if (a[i] < a[i+1]){
                    result[i] = a[i+1];
                }else {
                    int j = i+1;
                    result[i] = -1;
                    while (j < length-1){
                        if (result[j] == -1) break;
                        if (result[j] > a[i]){
                            result[i] = result[j];
                            break;
                        }
                        j++;
                    }
                }
            }

            return result;

        }
    }

}
