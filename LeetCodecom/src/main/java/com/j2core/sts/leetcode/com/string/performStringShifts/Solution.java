package com.j2core.sts.leetcode.com.string.performStringShifts;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class Solution {

    public String stringShift(String s, int[][] shift) {

        LinkedList<Character> characterList = new LinkedList<Character>();
        for (char character : s.toCharArray()){
            characterList.add(character);
        }

        int index = 0;
        char tmp;

        while (index < shift.length){
            if (shift[index][0] == 0){
                for (int i = 0; i < shift[index][1]; i++){
                    tmp = characterList.removeFirst();
                    characterList.addLast(tmp);
                }
            }else {
                for (int i = 0; i < shift[index][1]; i++){
                    tmp = characterList.removeLast();
                    characterList.addFirst(tmp);
                }
            }
            index++;
        }

        StringBuilder builder = new StringBuilder();

        for (char character : characterList){
            builder.append(character);
        }
        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(stringShift("abc", new int[][]{{0,1}, {1,2}}), "cab");
    }
}
