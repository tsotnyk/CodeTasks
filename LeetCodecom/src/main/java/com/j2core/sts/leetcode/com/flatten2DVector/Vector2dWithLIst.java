package com.j2core.sts.leetcode.com.flatten2DVector;

import java.util.ArrayList;

public class Vector2dWithLIst {

    ArrayList<Integer> list;
    int index;

    public Vector2dWithLIst(int[][] v) {
        this.list = new ArrayList<>();
        for (int[] array : v){
            if (array != null && array.length > 0){
                for (int num : array){
                    list.add(num);
                }
            }
        }
        this.index = list.size() > 0 ? 0 : -1;
    }

    public int next() {

        return list.get(index++);
    }

    public boolean hasNext() {

        if (list.size() > 0 && index < list.size()) return true;
        return false;
    }
}
