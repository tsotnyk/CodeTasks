package com.j2core.sts.codefights.com.dataStructures.heapsAndStacksAndQueues.nearestGreater;

public class Solution {

    int[] nearestGreater(int[] a) {

        int arrayLength = a.length;
        int[] result = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++){

            if (i == 0){
                int index = 1;
                while (index < arrayLength && a[i] >= a[index]){
                    index++;
                }
                if (index != arrayLength) {
                    result[i] = index;
                }else{
                    result[i] = -1;
                }
            }else if (a[i-1] > a[i]){
                result[i] = i-1;
            }else if (i+1 < arrayLength && a[i+1] > a[i]){
                result[i] = i+1;
            }else {
                int index = result[i-1];
                int delta = i - index;
                for (int k = 2; ; k++){
                    if (i-k < 0 && i+k >= arrayLength){
                        result[i] = -1;
                        break;
                    }else {
                        if (i-k > -1 && k >= delta){
                            if (a[i-k] > a[i]) {
                                result[i] = i - k;
                                break;
                            }else {
                                index = result[i-k];
                                if (index == -1){
                                    result[i] = i-k;
                                }else {
                                    delta = i-index;
                                }
                            }
                        }
                        if (i+k < arrayLength && a[i+k] > a[i]){
                            result[i] = i+k;
                            break;
                        }
                    }
                }
            }
        }

        return result;

    }
}
