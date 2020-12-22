package com.j2core.sts.leetcode.com.goalParserInterpretation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String interpret(String command) {

        StringBuilder builder = new StringBuilder();
        int index = 0;

        while (index < command.length()){
            if (command.charAt(index) == 'G'){
                builder.append('G');
            }else{
                int indexCloseBracket = command.indexOf(')',index+1);
                if (indexCloseBracket == index+1){
                    builder.append('o');
                }else {
                    builder.append("al");
                }
                index = indexCloseBracket;
            }
            index++;
        }

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(interpret("G()(al)"), "Goal");
        Assert.assertEquals(interpret("G()()()()(al)"), "Gooooal");
        Assert.assertEquals(interpret("(al)G(al)()()G"), "alGalooG");

    }
}
