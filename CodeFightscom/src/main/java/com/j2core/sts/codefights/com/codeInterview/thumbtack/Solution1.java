package com.j2core.sts.codefights.com.codeInterview.thumbtack;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {

    int[] ratingThreshold(double threshold, int[][] ratings) {

        ArrayList<Integer> result = new ArrayList<>(ratings.length);
        int index = 0;
        for (int[] pros : ratings){

            int sum = Arrays.stream(pros).sum();

            if (threshold > (double) sum/pros.length){
                result.add(index);
            }
            index++;
        }

        int [] array = new int[result.size()];

        for (int i = 0; i < array.length; i++){
            array[i] = result.get(i);
        }
        return array;
    }
}
