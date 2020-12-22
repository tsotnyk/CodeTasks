package com.j2core.sts.leetcode.com.string.findCommonCharacters;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> commonChars(String[] A) {

        int index = 0;
        int a = 'a';
        int[] baseCharacter = null;

        while (index < A.length){
            int[] characters = new int[26];
            for (int num : A[index++].chars().toArray()){
                characters[num-a] += 1;
            }
            if (baseCharacter != null) {
                for (int i = 0; i < baseCharacter.length; i++) {
                    if (baseCharacter[i] > 0) {
                        baseCharacter[i] = Math.min(baseCharacter[i], characters[i]);
                    }
                }
            }else baseCharacter = characters;
        }

        List<String> result = new LinkedList<>();
        for (int i = 0; i < baseCharacter.length; i++){
            if (baseCharacter[i] > 0){
                int counter = 0;
                while (counter++ < baseCharacter[i]){
                    result.add(String.valueOf((char) (i+a)));
                }
            }
        }

        return result;
    }


    @Test
    public void test(){

        Assert.assertEquals(commonChars(new String[]{"bella", "label", "roller"}), new LinkedList<>(Arrays.asList("e","l","l")));
    }
}
