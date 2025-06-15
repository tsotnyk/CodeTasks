package com.j2core.sts.gfg.array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RotateAnArrayByOne {

    int[] rotate(int[] arr){

        int tmp = arr[arr.length-1];
        for (int i = arr.length -2; i >= 0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = tmp;

        return arr;
    }

    @Test
    public void test_rotate(){

        String tmp = "1.2.3.4";
        String[] tmp1 = tmp.split("\\.");


        Assert.assertEquals(new int[]{1,2,3,4,5}, rotate(new int[]{2,3,4,5,1}));
    }
}
