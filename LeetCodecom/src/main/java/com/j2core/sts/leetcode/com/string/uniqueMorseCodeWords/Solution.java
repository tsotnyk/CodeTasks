package com.j2core.sts.leetcode.com.string.uniqueMorseCodeWords;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int uniqueMorseRepresentations(String[] words) {

        String[] moresCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        List<String> uniqueMorseCode = new LinkedList<>();

        for (String word : words){

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < word.length(); i++){

                int index = word.charAt(i) - 97;

                builder.append(moresCode[index]);

            }

            boolean flag = false;
            for (String code : uniqueMorseCode){

                if (code.equals(builder.toString())){
                    flag = true;
                    break;
                }
            }

            if (!flag){
                uniqueMorseCode.add(builder.toString());
            }
        }

        return uniqueMorseCode.size();

    }


    @Test
    public void test(){

        int result = uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});

        Assert.assertTrue(result == 2);

    }
}
