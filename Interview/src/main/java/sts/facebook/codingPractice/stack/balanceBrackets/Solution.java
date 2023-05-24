package sts.facebook.codingPractice.stack.balanceBrackets;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> bracketList = new Stack<>();
        char open1 = '(';
        char open2 = '[';
        char open3 = '{';
        char close1 = ')';
        char close2 = ']';
        char close3 = '}';
        for (char bracket : s.toCharArray()){
            if (bracket == open1 || bracket == open2 || bracket == open3){
                bracketList.add(bracket);
            }else {
                if (bracketList.isEmpty()) return false;

                if (bracket == close1){
                    if(bracketList.pop() != open1) {
                        return false;
                    }
                }else if (bracket == close2){
                    if (bracketList.pop() != open2){
                        return false;
                    }
                }else {
                    if (bracketList.pop() != open3){
                        return false;
                    }
                }
            }
        }

        return bracketList.isEmpty();
    }

    @Test
    public void test(){

        Assert.assertTrue(isBalanced("{[()]}"));
        Assert.assertTrue(isBalanced("{}()[]"));
        Assert.assertTrue(isBalanced("{()[]}"));
        Assert.assertTrue(isBalanced("{{[[(())]]}}"));
        Assert.assertFalse(isBalanced("{(})"));
        Assert.assertFalse(isBalanced(")"));

    }


}
