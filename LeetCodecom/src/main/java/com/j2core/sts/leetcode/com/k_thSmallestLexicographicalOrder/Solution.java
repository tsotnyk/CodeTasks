package com.j2core.sts.leetcode.com.k_thSmallestLexicographicalOrder;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public int findKthNumber(int n, int k) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            list.add(String.valueOf(i));
        }
        Collections.sort(list);

        return Integer.parseInt(list.get(k-1));
    }
}
