package com.j2core.sts.leetcode.com.string.partitionLabels;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();
        int deleteLength = 0;
        int index = -1;

        for (int i = 0; i < S.length(); i++){

            int last = S.lastIndexOf(S.charAt(i));

            if (index == -1) index = last;

            if (last == i && last == index){
                 int length = index - deleteLength + 1;
                    result.add(length);
                    deleteLength = deleteLength + length;
                    index = -1;

            }else if (last > index) index = last;

        }

        return result;

    }


    @Test
    public void test(){

        List<Integer> result = partitionLabels("ababcbacadefegdehijhklij");

        Assert.assertEquals(result.size(), 3);

    }
}
