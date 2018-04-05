package com.j2core.sts.codefights.com.rotateImage;

public class Solution {

    int[][] rotateImage(int[][] a) {

        for (int k = 0; k < a.length/2; k++){

            int numbers;
            for (int i = k; i < a.length-k-1; i++){

                numbers = a[k][i];
                a[k][i] = a[a.length-1-i][k];
                a[a.length-1-i][k] = a[a.length-1-k][a.length-1-i];
                a[a.length-1-k][a.length-1-i] = a[i][a.length-1-k];
                a[i][a.length-1-k] = numbers;

            }
        }

        return a;
    }
}
