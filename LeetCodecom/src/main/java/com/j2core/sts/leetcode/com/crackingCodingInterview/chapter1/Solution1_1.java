package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1_1 {

    public boolean isUniqSymbols(String string){

        if (string == null || string.length() <= 1) return true;
        if (string.length() > 128) return false;

        boolean[] uniqSymbols = new boolean[128];
        for (char symbol : string.toCharArray()){
            if (uniqSymbols[(int) symbol]){
                return false;
            }else {
                uniqSymbols[(int) symbol] = true;
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isUniqSymbols(""));
        Assert.assertTrue(isUniqSymbols(null));
        Assert.assertTrue(isUniqSymbols("abcde"));
        Assert.assertTrue(isUniqSymbols("zxy36cfj"));

        Assert.assertFalse(isUniqSymbols("sdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgthsdjfyldgth"));
        Assert.assertFalse(isUniqSymbols("aabdhjsdio"));
        Assert.assertFalse(isUniqSymbols("asdfghja"));

    }
}
