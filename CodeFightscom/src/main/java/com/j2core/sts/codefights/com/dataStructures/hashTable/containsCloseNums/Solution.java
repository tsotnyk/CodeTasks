package com.j2core.sts.codefights.com.dataStructures.hashTable.containsCloseNums;

import java.util.*;

public class Solution {

    boolean containsCloseNums(int[] nums, int k) {

        if (k < 1) return false;
        if (nums.length < 2) return false;

        List<Integer> uniqueNum = new ArrayList<>();
        Map<Integer, List<Integer>> numsMap = createNumsMap(nums, uniqueNum);

        for (Integer num : uniqueNum){

            List<Integer> tmpList = numsMap.get(num);
            int listSize = tmpList.size();

            if (tmpList.size() > 1){

                int delta;

                for (int i = listSize-1; i > 0; i--){

                    int base = tmpList.get(i);

                    for (int j = i-1; j > -1; j--){

                        delta = base - tmpList.get(j);
                        if (delta <= k) return true;

                    }
                }
            }
        }
        return false;
    }


    private Map<Integer, List<Integer>> createNumsMap(int[] nums, List<Integer> uniqueNum){

        Map<Integer, List<Integer>> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            List<Integer> tmpList;
            int tmpNum = nums[i];

            if (!result.containsKey(tmpNum)){
                tmpList = new LinkedList<>();
                tmpList.add(i);
                result.put(tmpNum, tmpList);
            }else {
                tmpList = result.get(tmpNum);
                if (tmpList.size() == 1) {
                    uniqueNum.add(tmpNum);
                }
                tmpList.add(i);
            }

        }

        return result;
    }
}
