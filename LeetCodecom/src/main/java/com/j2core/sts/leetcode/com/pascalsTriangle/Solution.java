package com.j2core.sts.leetcode.com.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) return result;

        List<Integer> tmpList = new ArrayList<>(1);
        tmpList.add(1);
        result.add(tmpList);
        for (int i = 1; i < numRows; i++){

            List<Integer> list = new ArrayList<>(i+2);
            list.add(1);

            for (int y = 1; y < i; y++){
                list.add(tmpList.get(y-1) + tmpList.get(y));
            }

            list.add(1);
            result.add(list);
            tmpList = list;
        }

        return result;
    }
}
