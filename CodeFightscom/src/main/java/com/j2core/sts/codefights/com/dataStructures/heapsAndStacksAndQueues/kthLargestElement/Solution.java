package com.j2core.sts.codefights.com.dataStructures.heapsAndStacksAndQueues.kthLargestElement;

public class Solution {

    int kthLargestElement(int[] nums, int k) {

        if (k > nums.length/2){

            int tmpArrayLength = nums.length - k + 1;
            int[] tmpArray = new int[tmpArrayLength];
            int index = 0;
            tmpArray[index] = nums[0];
            index++;

            for (int i = 1; i < nums.length; i++){

                boolean action = false;
                for (int j = 0; j < index; j++){

                    if (nums[i] < tmpArray[j]){

                        if (j < tmpArrayLength-1) {
                            System.arraycopy(tmpArray, j, tmpArray, j + 1, tmpArrayLength - j-1);
                            tmpArray[j] = nums[i];
                            action = true;
                            if (index < tmpArrayLength) index++;
                            break;
                        }else {
                            tmpArray[j] = nums[i];
                        }
                    }
                }
                if (index < tmpArrayLength && !action){

                    tmpArray[index] = nums[i];
                    index++;
                }
            }

            return tmpArray[tmpArrayLength-1];

        }else {

            int[] tmpArray = new int[k];
            int arrayIndex = k - 1;
            tmpArray[arrayIndex] = nums[0];
            arrayIndex--;

            for (int i = 1; i < nums.length; i++) {

                boolean action = false;
                for (int j = k - 1; j > arrayIndex; j--) {

                    if (nums[i] > tmpArray[j]) {

                        System.arraycopy(tmpArray, 1, tmpArray, 0, j);
                        tmpArray[j] = nums[i];
                        action = true;
                        if (arrayIndex > -1) arrayIndex--;
                        break;

                    }
                }
                if (arrayIndex > -1 && !action) {

                    tmpArray[arrayIndex] = nums[i];
                    arrayIndex--;
                }
            }

            return tmpArray[0];
        }
    }

}
