package com.j2core.sts.leetcode.com.sortArrayByParity;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] sortArrayByParity(int[] A) {

        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();

        for (int num : A) {

            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        even.addAll(odd);

        int index = 0;

        for (Integer num : even){

            A[index++] = num;
        }

        return A;
    }

}
