package com.j2core.sts.gfg.array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LeftRotationByDPositions {

    int[] rotate(int[] arr, int pos){
        int[] tmp = new int[pos];

        for (int i = 0; i < pos; i++){
            tmp[i] = arr[i];
        }
        int index = 0;
        for (int i = pos; i < arr.length; i++){
            arr[index++] = arr[i];
        }

        for (int i = 0; i < pos; i++){
            arr[index++] = tmp[i];
        }

        return arr;
    }

    @Test
    public void test_rotate(){

        Assert.assertEquals(new int[]{3,4,5,6,7,1,2}, rotate(new int[]{1,2,3,4,5,6,7}, 2));
    }
}
