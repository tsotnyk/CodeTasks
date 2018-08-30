package com.j2core.sts.intreviewbit.com.findDuplicateInArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int repeatedNumber(final List<Integer> a) {

        if(a.size() < 2) return -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : a){

            if (map.containsKey(num)){

                return num;
            }else {
                map.put(num, 1);
            }
        }

        return -1;
    }
}
