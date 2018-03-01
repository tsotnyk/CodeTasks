package com.j2core.sts.leetcode.com.selfDividingNumbers;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();
        if (left < 10){
            int tmpRight = 10;
            if (right < 10){
                tmpRight = right;
            }
            for (int i = left; i < tmpRight; i++){
                result.add(i);
            }
        }
        if (right <= 10) return result;
        int tmpLeft = 11;
        if (left > tmpLeft) tmpLeft = left;
        for (int j = tmpLeft; j <= right; j++){
            if (j%10 != 0){
                String tmpNum = Integer.toString(j);
                int[] tmpArray = new int[tmpNum.length()];
                for (int k = 0; k < tmpNum.length(); k++){
                    tmpArray[k] = Integer.parseInt(String.valueOf(tmpNum.charAt(k)));
                }
                boolean flag = true;
                for (int num : tmpArray){
                    if (num == 0 || j%num != 0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    result.add(j);
                }
            }
        }
        return  result;
    }
}
