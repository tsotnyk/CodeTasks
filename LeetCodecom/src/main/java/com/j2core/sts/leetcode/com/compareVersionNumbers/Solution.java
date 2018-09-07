package com.j2core.sts.leetcode.com.compareVersionNumbers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int compareVersion(String version1, String version2) {

        List<Integer> list1 = parsVersion(version1);
        List<Integer> list2 = parsVersion(version2);

        int index = 0;

        if (list1 != null && list2 != null) {

            while (index < list1.size() && index < list2.size()) {

                int tmpResult = list1.get(index).compareTo(list2.get(index));
                if (tmpResult == 0) {
                    index++;
                } else if (tmpResult < 0) {
                    return -1;
                } else return 1;

            }

            if (list2.size() > index) {
                return -1;
            } else if (list1.size() > index) {
                return 1;
            }
        }
        return 0;
    }

    private List<Integer> trimZero(List<Integer> list){

        int lastIndex = list.size()-1;
        int lastNum = list.get(lastIndex);

        while (lastNum == 0 && lastIndex > 0){

            list.remove(lastIndex);
            lastIndex--;
            if (lastIndex > -1){
                lastNum = list.get(lastIndex);
            }

        }

        return list;

    }

    private List<Integer> parsVersion(String version){

        List<Integer> result = new LinkedList<>();

        int index = 0;
        int startIndex = 0;

        while (index < version.length()){

            if (version.charAt(index) == '.'){

                result.add(Integer.valueOf(version.substring(startIndex, index)));
                index++;
                startIndex = index;


            }else {

                index++;
            }

        }

        if (startIndex != index){

            result.add(Integer.parseInt(version.substring(startIndex)));
        }

        return trimZero(result);

    }


    @Test
    public void test(){

        int result = compareVersion("0.1", "0.0.1");

        Assert.assertTrue(result == 1);

    }

}
