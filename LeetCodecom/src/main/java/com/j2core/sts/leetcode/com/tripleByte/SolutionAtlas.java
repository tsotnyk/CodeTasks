package com.j2core.sts.leetcode.com.tripleByte;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionAtlas {

    public static int toolchanger(List<String> tools, int k, String q) {
        // Write your code here

        if (tools.get(k).equals(q)) return 0;

        int countLeft = 1;
        int countRight = 1;
        int indexLeft = k-1;
        int indexRight = k+1;

        while (true){

            if (indexRight == tools.size()){
                indexRight = 0;
            }
            if (indexLeft < 0){
                indexLeft = tools.size()-1;
            }

            if (tools.get(indexLeft).equals(q)){
                return countLeft;
            }else {
                countLeft++;
                indexLeft--;
            }
            if (tools.get(indexRight).equals(q)){
                return countRight;
            }else {
                countRight++;
                indexRight++;
            }
        }
    }

    @Test
    public void test(){

        List<String> list = new LinkedList<>(Arrays.asList(new String[]{"aaa", "bbb", "ccc", "ddd"}));
        List<String> list1 = new LinkedList<>(Arrays.asList(new String[]{"aaa", "bbb", "ccc", "ccc"}));

        Assert.assertEquals(toolchanger(list, 1, "aaa"), 1);
        Assert.assertEquals(toolchanger(list, 1, "ddd"), 2);
        Assert.assertEquals(toolchanger(list1, 0, "ccc"), 1);
    }

    public static int findSmallestDivisor(String s, String t) {
        // Write your code here

        if (s.length()%t.length() != 0) return -1;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i*t.length() < s.length(); i++) {
            builder.append(t);
        }

        if (s.equals(builder.toString())){

            for(int i = 1; i <= t.length(); i++) {
                String subStr = t.substring(0, i);
                int index = i+i;
                if (index > t.length()) return t.length();
                String nextSubStr = t.substring(i, index);
                if(subStr.equals(nextSubStr))
                    return i;
            }
        }

        return -1;
    }

    @Test
    public void test2(){

        String s1 = "bcdbcdbcdbcd", t1 = "bcdbcd";
        String s2 = "bcdbcdbcd", t2 = "bcdbcd";
        String s3 = "lrbblrbb", t3 = "lrbb";
        String s4 = "rbrb", t4 = "rbrb";

        Assert.assertEquals(findSmallestDivisor(s1, t1), 3);
        Assert.assertEquals(findSmallestDivisor(s2, t2), -1);
        Assert.assertEquals(findSmallestDivisor(s3, t3), 4);
        Assert.assertEquals(findSmallestDivisor(s4, t4), 2);

    }
}
