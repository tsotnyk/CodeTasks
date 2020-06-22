package com.j2core.sts.leetcode.com.hackerrank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static java.util.Arrays.asList;

public class Solution3 {

    public static List<Integer> findSubsequence(List<Integer> numbers, int k) {
        // Write your code here

        if (k == numbers.size()) return numbers;

        int [] array = new int[numbers.size()];
        int index = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int num : numbers){
            array[index] = num;
            if (map.containsKey(num)){
                map.get(num).add(num);
            }
            map.put(num, new ArrayList<>(Arrays.asList(num)));
            for (int i = index; i > -1; i--){
                if (i != index && num%array[i] == 0){
                    map.get(array[i]).add(num);
                }
            }
            index++;
        }

        Arrays.sort(array);

        List<Integer> result = null;

        for (int i = array.length-k; i > -1; i--){
            List<Integer> list = map.get(array[i]);
            if (list.size() >= k) return list;
        }
        return result;
    }

    @Test
    public void test(){

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(5,4,15,20,1));
        Assert.assertEquals(findSubsequence(list, 3 ).size(), 3);
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,8,5,6));
        Assert.assertEquals(findSubsequence(list2, 2 ).size(), 3);

        List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(6,24,12,1));
        Assert.assertEquals(findSubsequence(list3, 4 ).size(), 4);
    }
}
