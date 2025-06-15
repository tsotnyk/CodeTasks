package com.j2core.sts.gfg.array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AddingOneToNumberRepresentedAsArrayOfDigits {

    int[] addOne(int[] arr){

        for (int i = arr.length-1; i >= 0; i--){
            if (arr[i] < 9){
                arr[i] = arr[i]+1;
                return arr;
            }
            arr[i] = 0;
        }

        int[] res = new int[arr.length+1];
        res[0] = 1;
        System.arraycopy(arr, 0, res, 1, arr.length);
        return res;
    }

    @Test
    public void test_rotate(){

        Assert.assertEquals(new int[]{1,3,0,0}, addOne(new int[]{1,2,9,9}));
        Assert.assertEquals(new int[]{1,0,0,0}, addOne(new int[]{9,9,9}));

    }
}
